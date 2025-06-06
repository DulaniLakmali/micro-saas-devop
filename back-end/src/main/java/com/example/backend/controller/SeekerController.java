package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Consultant;
import com.example.backend.model.Seeker;
import com.example.backend.repository.SeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:3000")
public class SeekerController {

    @Autowired
    private SeekerRepository SeekerRepo;

    @PostMapping("/LoginSeeker")
    public ResponseEntity<?> login(@RequestBody Seeker loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Seeker seeker = SeekerRepo.findByUsername(username);

        if (seeker == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        if (!password.equals(seeker.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        return ResponseEntity.ok(seeker.getSeeker_id());
    }

    @PostMapping("/RegisterSeeker")
    public ResponseEntity<Seeker> newSeeker(@RequestBody Seeker newSeeker){
        SeekerRepo.save(newSeeker);
        return ResponseEntity.ok(newSeeker);
    }

    @GetMapping("/AllSeekers")
    List<Seeker> getAllSeekers(){
        return SeekerRepo.findAll();
    }

    @GetMapping("/Seeker/{seekerId}")
    public Seeker getSeekerById(@PathVariable Integer seekerId){
        return SeekerRepo.findById(seekerId)
                .orElseThrow(()-> new UserNotFoundException(seekerId));
    }
}
