package com.dhrithi.curewell.backend.services.impl;

import com.dhrithi.curewell.backend.entity.Doctor;
import com.dhrithi.curewell.backend.entity.DoctorSpecialization;
import com.dhrithi.curewell.backend.entity.Specialization;
import com.dhrithi.curewell.backend.repository.DoctorSpecializationRepository;
import com.dhrithi.curewell.backend.repository.DoctorRepository;
import com.dhrithi.curewell.backend.repository.SpecializationRepository;
import com.dhrithi.curewell.backend.services.DoctorSpecializationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorSpecializationServiceImpl implements DoctorSpecializationService {

    private DoctorSpecializationRepository doctorSpecRepository;
    private DoctorRepository doctorRepository;
    private SpecializationRepository specializationRepository;

    public DoctorSpecializationServiceImpl(DoctorSpecializationRepository doctorSpecializationRepository,
                                           DoctorRepository doctorRepository,
                                           SpecializationRepository specializationRepository) {
        this.doctorSpecRepository = doctorSpecRepository;
        this.doctorRepository = doctorRepository;
        this.specializationRepository = specializationRepository;
    }

    @Override
    public List<DoctorSpecialization> getAllDoctorSpec() {
        return doctorSpecRepository.findAll();
    }

    @Override
    public DoctorSpecialization addDoctorSpecialization(Long doctorId, String specCode, LocalDate specializationDate) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Specialization> specialisation = specializationRepository.findById(specCode);

        if (doctor.isEmpty() || specialisation.isEmpty()) {
            throw new RuntimeException("Doctor or Specialisation not found!");
        }

        DoctorSpecialization doctorSpecialization = new DoctorSpecialization(doctor.get(), specialisation.get(), specializationDate);
        return doctorSpecRepository.save(doctorSpecialization);
    }
}