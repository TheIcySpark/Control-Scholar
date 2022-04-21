package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.Admin;
import com.ControlScholarAPI.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
        return ResponseEntity.ok().body(adminService.saveAdmin(admin));
    }

    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> getAdmins(){
        return ResponseEntity.ok().body(adminService.getAdmins());
    }

    @DeleteMapping("/admin/drop")
    public void dropAdmin(@RequestBody Admin admin){
        adminService.dropAdmin(admin);
    }

}
