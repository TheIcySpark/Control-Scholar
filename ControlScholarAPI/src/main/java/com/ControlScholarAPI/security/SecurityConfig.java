package com.ControlScholarAPI.security;

import com.ControlScholarAPI.constant.LearningCenterLocations;
import com.ControlScholarAPI.constant.Roles;
import com.ControlScholarAPI.filter.CustomAuthenticationFilter;
import com.ControlScholarAPI.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/member/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);

        http.authorizeRequests().antMatchers("/api/member/login").permitAll();
        http.authorizeRequests().antMatchers("/api/libraryManager/**").hasAnyAuthority("ROLE_LIBRARY_MANAGER", "ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/api/admin/**").hasAnyAuthority("ROLE_ADMIN");
        int i = 0;
        while(i <= LearningCenterLocations.locations.size()){
            http.authorizeRequests().antMatchers("/api/libraryManager/" + LearningCenterLocations.locations.get(i) + "/**").hasAnyAuthority(Roles.locationRoles.get(i));
            http.authorizeRequests().antMatchers("/api/admin/" + LearningCenterLocations.locations.get(i) + "/**").hasAnyAuthority(Roles.locationRoles.get(i));
        }

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

}
