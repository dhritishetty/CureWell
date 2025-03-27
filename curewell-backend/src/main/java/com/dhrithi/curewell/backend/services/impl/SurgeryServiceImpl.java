package com.dhrithi.curewell.backend.services.impl;

import com.dhrithi.curewell.backend.entity.Doctor;
import com.dhrithi.curewell.backend.entity.Surgery;
import com.dhrithi.curewell.backend.repository.DoctorRepository;
import com.dhrithi.curewell.backend.repository.SurgeryRepository;
import com.dhrithi.curewell.backend.services.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    // Get all surgeries
    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    // Get surgery by ID
    @Override
    public Surgery getSurgeryById(Long SurgId) {
        return surgeryRepository.findById(SurgId)
                .orElseThrow(() -> new RuntimeException("Surgery not found with ID: " + SurgId));
    }

    // Add a new surgery
    @Override
    public Surgery addSurgery(Long doctorId, String surgeryName, String specCode, LocalTime startTime, LocalTime endTime, LocalDate surgeryDate) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);

        if (doctorOptional.isEmpty()) {
            throw new RuntimeException("Doctor not found with ID: " + doctorId);
        }

        Doctor doctor = doctorOptional.get();

        Surgery surgery = new Surgery();
        surgery.setDoctor(doctor);  // Set the fetched Doctor
        surgery.setSurgeryName(surgeryName);
        surgery.setSpecCode(specCode);
        surgery.setStartTime(startTime);
        surgery.setEndTime(endTime);
        surgery.setSurgeryDate(surgeryDate);

        return surgeryRepository.save(surgery);
    }

    // Update an existing surgery
    @Override
    public Surgery updateSurgery(Long surgId, Surgery surgeryDetails) {
        Surgery surgery = surgeryRepository.findById(surgId)
                .orElseThrow(() -> new RuntimeException("Surgery not found with ID: " + surgId));

        // Ensure doctorId is part of the surgery object
        Long doctorId = surgeryDetails.getDoctor().getDoctorId();
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isEmpty()) {
            throw new RuntimeException("Doctor not found with ID: " + doctorId);
        }
        Doctor doctor = doctorOptional.get();

        // Set the doctor and update surgery details
        surgery.setDoctor(doctor);
        surgery.setSurgeryName(surgeryDetails.getSurgeryName());
        surgery.setSpecCode(surgeryDetails.getSpecCode());
        surgery.setStartTime(surgeryDetails.getStartTime());
        surgery.setEndTime(surgeryDetails.getEndTime());
        surgery.setSurgeryDate(surgeryDetails.getSurgeryDate());

        return surgeryRepository.save(surgery);
    }


    // Delete a surgery by ID
    @Override
    public void deleteSurgery(Long surgId) {
        surgeryRepository.deleteById(surgId);
    }

    @Override
    public List<Surgery> getSurgeriesByDate() {
        LocalDate today = LocalDate.now();
        return surgeryRepository.findBySurgeryDate(today);
    }
}
