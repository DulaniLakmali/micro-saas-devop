package com.example.backend.repository;

import com.example.backend.model.Appointment;
import com.example.backend.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository <Availability,Integer> {

    List<Availability> findAllByConsultantId(Integer consultantId);
}
