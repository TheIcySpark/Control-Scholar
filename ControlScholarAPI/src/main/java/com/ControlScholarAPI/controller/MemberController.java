package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.Member;
import com.ControlScholarAPI.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/member/add")
    public ResponseEntity<Member>saveMember(@RequestBody Member member){
        return ResponseEntity.ok().body(memberService.saveMember(member));
    }

}
