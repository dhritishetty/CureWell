package com.dhrithi.curewell.backend.controller;

import com.dhrithi.curewell.backend.entity.Specialization;
import com.dhrithi.curewell.backend.services.SpecializationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/specializations")
@CrossOrigin(origins = "*")
public class SpecializationController {

    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping
    public List<Specialization> getAllSpecialisations() {
        return specializationService.getAllSpecialisation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialization> getSpecialisationById(@PathVariable String specCode) {
        return ResponseEntity.ok(specializationService.getSpecialisationById(specCode));
    }

    @PostMapping
    public ResponseEntity<Specialization> addSpecialisation(@RequestBody Specialization specialization) {
        System.out.println("Received Specialisation: Name = " + specialization.getSpecName() + ", Code = " + specialization.getSpecCode());

        Specialization savedSpecialization = specializationService.addSpecialisation(specialization);
        return ResponseEntity.ok(savedSpecialization);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Specialization> updateSpecialisation(@PathVariable String specCode, @RequestBody Specialization specialization) {
        return ResponseEntity.ok(specializationService.updateSpecialisation(specCode, specialization));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialisation(@PathVariable String specCode) {
        specializationService.deleteSpecialisation(specCode);
        return ResponseEntity.noContent().build();
    }

}