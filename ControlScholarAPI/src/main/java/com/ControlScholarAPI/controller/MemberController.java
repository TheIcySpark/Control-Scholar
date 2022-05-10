package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.*;
import com.ControlScholarAPI.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("{center}/add")
    public ResponseEntity<Member>saveMember(@RequestBody Member member){
        return ResponseEntity.ok().body(memberService.saveMember(member));
    }

    @GetMapping("/member/get/all")
    public ResponseEntity<List<Member>>getMembers(){
        return ResponseEntity.ok().body(memberService.getMembers());
    }


    @PostMapping("/{center}/student/enrollSemester/add")
    public ResponseEntity<EnrollSemester> saveEnrollSemester(EnrollSemester enrollSemester){
        return ResponseEntity.ok().body(memberService.saveEnrollSemester(enrollSemester));
    }


    @PostMapping("/{center}/grade/add")
    public ResponseEntity<Grade> saveGrade(Grade grade){
        return ResponseEntity.ok().body(memberService.saveGrade(grade));
    }

    @PostMapping("/{center}/enrollDegre/add")
    public ResponseEntity<EnrollDegree>saveEnrollDegree(EnrollDegree enrollDegree){
        return ResponseEntity.ok().body(memberService.saveEnrollDegree(enrollDegree));
    }
}
