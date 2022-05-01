package com.ControlScholarAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/{center}/t")
    public ResponseEntity<String> saludar(@PathVariable String center){
        return ResponseEntity.ok().body("hola" + center);
    }
}
