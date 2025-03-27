package com.dhrithi.curewell.backend.repository;

import com.dhrithi.curewell.backend.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization,String> {
    
}
