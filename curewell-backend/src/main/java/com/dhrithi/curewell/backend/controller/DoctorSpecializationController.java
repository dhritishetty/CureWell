package com.dhrithi.curewell.backend.controller;

import com.dhrithi.curewell.backend.entity.DoctorSpecialization;
import com.dhrithi.curewell.backend.services.DoctorSpecializationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/doctor-specializations")
@CrossOrigin(origins = "*")
public class DoctorSpecializationController {

    private final DoctorSpecializationService doctorSpecializationService;

    public DoctorSpecializationController(DoctorSpecializationService doctorSpecializationService) {
        this.doctorSpecializationService = doctorSpecializationService;
    }
    @GetMapping
    public List<DoctorSpecialization> getAllDoctorSpecialisations() {
        return doctorSpecializationService.getAllDoctorSpec();
    }

    @PostMapping
    public ResponseEntity<DoctorSpecialization> addDoctorSpecialization(@RequestBody Map<String, Object> request) {
        Long doctorId = Long.valueOf(request.get("doctorId").toString());
        String specCode = request.get("specializationId").toString(); // Fix: Convert to Long
        LocalDate specializationDate = LocalDate.parse(request.get("specializationDate").toString());

        DoctorSpecialization newEntry = doctorSpecializationService.addDoctorSpecialization(doctorId, specCode, specializationDate);
        return ResponseEntity.ok(newEntry);
    }
}
