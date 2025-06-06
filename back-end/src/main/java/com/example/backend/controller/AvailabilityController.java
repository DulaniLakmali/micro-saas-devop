package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Availability;
import com.example.backend.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:3000")
public class AvailabilityController {

    @Autowired
    private AvailabilityRepository availabilityRepo;

    @PostMapping("/NewAvailability")
    public ResponseEntity<Availability> newAvailability(@RequestBody Availability newAvailability){
        availabilityRepo.save(newAvailability);
        return ResponseEntity.ok(newAvailability);
    }

    @PutMapping("/EditAvailability/{availabilityId}")
    Availability editAvailability(@RequestBody Availability editAvailability, @PathVariable Integer availabilityId){
        return availabilityRepo.findById(availabilityId)
                .map(availability -> {
                    availability.setDate(editAvailability.getDate());
                    availability.setTime(editAvailability.getTime());
                    availability.setAvailability(editAvailability.getAvailability());

                    return availabilityRepo.save(availability);
                }).orElseThrow(()-> new UserNotFoundException(availabilityId));
    }

    @DeleteMapping("/DeleteAvailability/{availabilityId}")
    String deleteAvailability(@PathVariable Integer availabilityId) {
        if (!availabilityRepo.existsById(availabilityId)) {
            throw new UserNotFoundException(availabilityId);
        }
        availabilityRepo.deleteById(availabilityId);
        return "User with id " + availabilityId + " has been deleted successfully";
    }

    @GetMapping("/Availability")
    List<Availability> getAllAvailability(){
        return availabilityRepo.findAll();
    }

    @GetMapping("/ConsultantAvailability/{consultantId}")
    public List<Availability> getAppointmentBySeekerId(@PathVariable Integer consultantId){
        return availabilityRepo.findAllByConsultantId(consultantId);
    }
}
