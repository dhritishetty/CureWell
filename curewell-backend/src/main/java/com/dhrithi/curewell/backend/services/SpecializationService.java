package com.dhrithi.curewell.backend.services;

import com.dhrithi.curewell.backend.entity.Specialization;

import java.util.List;

public interface SpecializationService {
    List<Specialization> getAllSpecialisation();
    Specialization getSpecialisationById(String specCode);
    Specialization addSpecialisation(Specialization specialization);
    Specialization updateSpecialisation(String specCode, Specialization specialization);
    void deleteSpecialisation(String specCode);
}
