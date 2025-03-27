package com.dhrithi.curewell.backend.repository;

import com.dhrithi.curewell.backend.entity.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SurgeryRepository extends JpaRepository<Surgery,Long> {
    List<Surgery> findBySurgeryDate(LocalDate surgeryDate);
}
