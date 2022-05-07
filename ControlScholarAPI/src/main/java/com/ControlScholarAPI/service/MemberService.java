package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.*;
import com.ControlScholarAPI.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService{
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private EnrollSemesterRepo enrollSemesterRepo;
    @Autowired
    private DegreeRepo degreeRepo;
    @Autowired
    private GradeRepo gradeRepo;
    @Autowired
    private EnrollDegreRepo enrollDegreRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;




    public MemberService(MemberRepo memberRepo, PasswordEncoder passwordEncoder) {
        this.memberRepo = memberRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepo.findById(Integer.valueOf(username));
        Member member = optionalMember.get();
        if(member == null){
            throw new UsernameNotFoundException("User not found in the database");
        }else{

        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println(member.getRoles());
        String[] roles = member.getRoles().split(" ");
        for (String role:roles){
            authorities.add(new SimpleGrantedAuthority(role));
            System.out.println(role);
        }
        return new org.springframework.security.core.userdetails.User(username, member.getPassword(), authorities);
    }


    public Member saveMember(Member member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepo.save(member);
    }

    public List<Member> getMembers(){
        return memberRepo.findAll();
    }

    public EnrollSemester saveEnrollSemester(EnrollSemester enrollSemester){
        return enrollSemesterRepo.save(enrollSemester);
    }

    public Degree saveDegree(Degree degree){
        return degreeRepo.save(degree);
    }

    public Grade saveGrade(Grade grade){
        return gradeRepo.save(grade);
    }

    public EnrollDegree saveEnrollDegree(EnrollDegree enrollDegree){
        return enrollDegreRepo.save(enrollDegree);
    }

}
