package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Member;
import com.ControlScholarAPI.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepo.findByUsername(username);
        if(member == null){
            throw new UsernameNotFoundException("User not found in the database");
        }else{

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.getType()));
        return new org.springframework.security.core.userdetails.User(member.getUsername(), member.getPassword(), authorities);
    }

    public Member saveMember(Member member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepo.save(member);
    }

    public List<Member> getMembers(){
        return memberRepo.findAll();
    }
}
