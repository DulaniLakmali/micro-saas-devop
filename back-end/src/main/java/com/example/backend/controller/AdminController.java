package com.example.backend.controller;

import com.example.backend.model.Admin;
import com.example.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:3000")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/LoginAdmin")
    public ResponseEntity<?> Login(@RequestBody Admin loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Admin admin = adminRepository.findByUsername(username);

        if (admin == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        if (!password.equals(admin.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.ok(admin.getAdminId());
    }

}
