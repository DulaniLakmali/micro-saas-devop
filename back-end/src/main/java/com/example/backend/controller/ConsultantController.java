package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Admin;
import com.example.backend.model.Consultant;
import com.example.backend.repository.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:3000")
public class ConsultantController {

    @Autowired
    private ConsultantRepository consultantRepo;

    @PostMapping("/LoginConsultant")
    public ResponseEntity<?>Login(@RequestBody Consultant loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Consultant consultant = consultantRepo.findByUsername(username);

        if (consultant == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        if (!password.equals(consultant.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.ok(consultant.getConsultantId());
    }

    @PostMapping("/RegisterConsultant")
    public ResponseEntity<Consultant> newConsultant(@RequestBody Consultant newConsultant){
        consultantRepo.save(newConsultant);
        return ResponseEntity.ok(newConsultant);
    }

    @GetMapping("/AllConsultant")
    List<Consultant> getAllConsultant(){
        return consultantRepo.findAll();
    }

    @GetMapping("/Consultant/{consultantId}")
    public Consultant getConsultantById(@PathVariable Integer consultantId){
        return consultantRepo.findById(consultantId)
                .orElseThrow(() -> new UserNotFoundException(consultantId));
    }
}
