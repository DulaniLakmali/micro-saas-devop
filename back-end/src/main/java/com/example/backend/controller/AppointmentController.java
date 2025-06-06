package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.Appointment;
import com.example.backend.repository.AppointmentRepository;
import com.example.backend.repository.SeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:3000")
public class AppointmentController {

    @Autowired
    private AppointmentRepository AppointmentRepo;
    private SeekerRepository SeekerRepo;

    @PostMapping("/MakeAppointment")
    public ResponseEntity<Appointment> newAppointment(@RequestBody Appointment newAppointment){
        AppointmentRepo.save(newAppointment);
        return ResponseEntity.ok(newAppointment);
    }

    @GetMapping("/Appointments")
    public List<Appointment> getAppointments(){
        return AppointmentRepo.findAll();
    }

    @GetMapping("/Appointments/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable String status){
        return AppointmentRepo.findAllByStatus(status);
    }

    @GetMapping("/SeekerAppointments/{seekerId}")
    public List<Appointment> getAppointmentBySeekerId(@PathVariable Integer seekerId){
        return AppointmentRepo.findAllBySeekerId(seekerId);
    }

    @GetMapping("/ConsultantAppointments/{consultantId}")
    public List<Appointment> getAppointmentByConsultantId(@PathVariable Integer consultantId){
        return AppointmentRepo.findAllByConsultantId(consultantId);
    }

    @PutMapping("/UpdateAppointmentStatus/{appointmentId}/{appointmentStatus}")
    Appointment updateStatus(@RequestBody Appointment update, @PathVariable Integer appointmentId, @PathVariable String appointmentStatus){
        return AppointmentRepo.findById(appointmentId)
                .map(appointment -> {
                    appointment.setStatus(appointmentStatus);

                    return AppointmentRepo.save(appointment);
                }).orElseThrow(()-> new UserNotFoundException(appointmentId));
    }

    @GetMapping("/Appointments/{consultantId}/{status}")
    public List<Appointment> getAppointmentByStatus(@PathVariable Integer consultantId, @PathVariable String status){
        return AppointmentRepo.findAllByConsultantIdAndStatus(consultantId, status);
    }

    @DeleteMapping("/DeleteAppointment/{appointmentId}")
    String deleteAppointmentId(@PathVariable Integer appointmentId) {
        if (!AppointmentRepo.existsById(appointmentId)) {
            throw new UserNotFoundException(appointmentId);
        }
        AppointmentRepo.deleteById(appointmentId);
        return "AppointmentId with id " + appointmentId + " has been deleted successfully";
    }
}
