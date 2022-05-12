package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.*;
import com.ControlScholarAPI.service.LearningCenterService;
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
    @Autowired
    private LearningCenterService learningCenterService;

    @PostMapping("{center}/add")
    public ResponseEntity<Member>saveMember(@PathVariable String center, @RequestBody Member member){
        member.setLearningCenter(learningCenterService.getLearningCenterByLocation(center));
        return ResponseEntity.ok().body(memberService.saveMember(member));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Member>getMember(@PathVariable int id){
        return ResponseEntity.ok().body(memberService.getById(id));
    }

    @GetMapping("/member/get/all")
    public ResponseEntity<List<Member>>getMembers(){
        return ResponseEntity.ok().body(memberService.getMembers());
    }

}
