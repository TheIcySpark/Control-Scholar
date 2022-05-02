package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.Member;
import com.ControlScholarAPI.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/member/save")
    public ResponseEntity<Member>saveMember(@RequestBody Member member){
        return ResponseEntity.ok().body(memberService.saveMember(member));
    }

    @GetMapping("/member/get/all")
    public ResponseEntity<List<Member>>getMembers(){
        return ResponseEntity.ok().body(memberService.getMembers());
    }

}
