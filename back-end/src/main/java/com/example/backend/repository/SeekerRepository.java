package com.example.backend.repository;

import com.example.backend.model.Appointment;
import com.example.backend.model.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeekerRepository extends JpaRepository <Seeker,Integer> {

    Seeker findByUsername(String username);
}
