package com.dhrithi.curewell.backend.services;

import com.dhrithi.curewell.backend.entity.Surgery;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SurgeryService {
    List<Surgery> getAllSurgeries();
    Surgery getSurgeryById(Long SurgId);
    Surgery addSurgery(Long doctorId, String surgeryName, String specCode, LocalTime startTime, LocalTime endTime, LocalDate surgeryDate);

    Surgery updateSurgery(Long SurgId, Surgery surgery);

    void deleteSurgery(Long SurgId);

    List<Surgery> getSurgeriesByDate();
}
