package com.example.backend.repository;

import com.example.backend.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository <Consultant,Integer> {
    Consultant findByUsername(String username);
}
