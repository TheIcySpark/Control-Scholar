package com.ControlScholarAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/{center}/t")
    public ResponseEntity<String> saludar(@PathVariable String center){
        return ResponseEntity.ok().body("hola" + center);
    }
}
