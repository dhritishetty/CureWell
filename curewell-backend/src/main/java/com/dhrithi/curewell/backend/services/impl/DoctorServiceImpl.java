package com.dhrithi.curewell.backend.services.impl;

import com.dhrithi.curewell.backend.entity.Doctor;
import com.dhrithi.curewell.backend.repository.DoctorRepository;
import com.dhrithi.curewell.backend.services.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;


    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Implement the getAllDoctors() method
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Implement the getDoctorById() method
    @Override
    public Doctor getDoctorById(Long docId) {
        return doctorRepository.findById(docId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + docId));
    }

    // Implement the addDoctor() method
    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Implement the updateDoctor() method
    @Override
    public Doctor updateDoctor(Long docId, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(docId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + docId));

        // Update fields as needed (e.g., updating name, specialization)
        doctor.setDoctorName(doctorDetails.getDoctorName());
        // Add other fields to update as necessary

        return doctorRepository.save(doctor);
    }

    // Implement the deleteDoctor() method
    @Override
    public void deleteDoctor(Long docId) {
        doctorRepository.deleteById(docId);
    }



}
