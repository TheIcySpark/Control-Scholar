package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Admin;
import com.ControlScholarAPI.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public Admin saveAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    public List<Admin> getAdmins(){
        return adminRepo.findAll();
    }

    public void dropAdmin(Admin admin){
        adminRepo.delete(admin);
    }
}
