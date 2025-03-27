package com.dhrithi.curewell.backend.services.impl;

import com.dhrithi.curewell.backend.entity.Specialization;
import com.dhrithi.curewell.backend.repository.DoctorSpecializationRepository;
import com.dhrithi.curewell.backend.repository.DoctorRepository;
import com.dhrithi.curewell.backend.repository.SpecializationRepository;
import com.dhrithi.curewell.backend.services.SpecializationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {
    private final SpecializationRepository specializationRepository;
    private DoctorSpecializationRepository doctorSpecRepository;
    private DoctorRepository doctorRepository;

    public SpecializationServiceImpl(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public List<Specialization> getAllSpecialisation() {
        return specializationRepository.findAll();
    }

    @Override
    public Specialization getSpecialisationById(String specCode) {
        return specializationRepository.findById(specCode)
                .orElseThrow(() -> new RuntimeException("Specialisation not found with ID: " + specCode));
    }

    @Override
    public Specialization addSpecialisation(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    @Override
    public Specialization updateSpecialisation(String specCode, Specialization specializationDetails) {
        Specialization specialization = specializationRepository.findById(specCode)
                .orElseThrow(() -> new RuntimeException("Specialisation not found with ID: " + specCode));

        // Update details
        specialization.setSpecName(specializationDetails.getSpecName());
        specialization.setSpecCode(specializationDetails.getSpecCode());

        return specializationRepository.save(specialization);
    }

    // Delete a specialisation by ID
    @Override
    public void deleteSpecialisation(String specCode) {
        specializationRepository.deleteById(specCode);
    }


}
