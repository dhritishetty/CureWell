package com.dhrithi.curewell.backend.services;

import com.dhrithi.curewell.backend.entity.DoctorSpecialization;

import java.time.LocalDate;
import java.util.List;

public interface DoctorSpecializationService {
    List<DoctorSpecialization> getAllDoctorSpec();
    DoctorSpecialization addDoctorSpecialization(Long doctorId, String specCode, LocalDate specializationDate);
}
