package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.constant.LearningCenterLocations;
import com.ControlScholarAPI.model.*;
import com.ControlScholarAPI.service.LearningCenterService;
import com.ControlScholarAPI.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private LearningCenterService learningCenterService;

    @PostMapping("member/{center}/add")
    public ResponseEntity<Member>saveMember(@PathVariable String center, @RequestBody Member member){
        if(LearningCenterLocations.checkIfLocation(center)){
            member.setLearningCenter(learningCenterService.getLearningCenterByLocation(center));
            return ResponseEntity.ok().body(memberService.saveMember(member));
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("memberNotSecure/get/{id}")
    public ResponseEntity<Member>getMember(@PathVariable int id){
        // no security
        Member member = memberService.getById(id);
        member.setPassword("");
        member.setRoles("");
        member.setId(0);
        return ResponseEntity.ok().body(member);
    }

    @GetMapping("/member/get/all")
    public ResponseEntity<List<Member>>getMembers(){
        return ResponseEntity.ok().body(memberService.getMembers());
    }

}
