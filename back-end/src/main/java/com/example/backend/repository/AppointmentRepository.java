package com.example.backend.repository;

import com.example.backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository <Appointment,Integer>{
    List<Appointment> findAllBySeekerId(Integer seekerId);

    List<Appointment> findAllByConsultantId(Integer consultantId);

    List<Appointment> findAllByConsultantIdAndStatus(Integer consultantId, String status);

    List<Appointment> findAllByStatus(String status);
}
