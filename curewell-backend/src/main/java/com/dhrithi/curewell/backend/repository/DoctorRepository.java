package com.dhrithi.curewell.backend.repository;

import com.dhrithi.curewell.backend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
