package com.dhrithi.curewell.backend.controller;

import com.dhrithi.curewell.backend.entity.Surgery;
import com.dhrithi.curewell.backend.services.SurgeryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/surgeries")
@CrossOrigin(origins = "*")
public class SurgeryController {

    private final SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @GetMapping
    public List<Surgery> getAllSurgeries() {
        return surgeryService.getAllSurgeries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Surgery> getSurgeryById(@PathVariable Long id) {
        return ResponseEntity.ok(surgeryService.getSurgeryById(id));
    }

    @PostMapping
    public ResponseEntity<Surgery> addSurgery(@RequestBody Map<String, Object> request) {
        Long doctorId = Long.valueOf(request.get("doctorId").toString());
        String surgeryName = request.get("surgeryName").toString();
        String specCode = request.get("specCode").toString();
        LocalTime startTime = LocalTime.parse(request.get("startTime").toString());
        LocalTime endTime = LocalTime.parse(request.get("endTime").toString());
        LocalDate surgeryDate = LocalDate.parse(request.get("surgeryDate").toString());

        Surgery newSurgery = surgeryService.addSurgery(doctorId, surgeryName, specCode, startTime, endTime, surgeryDate);
        return ResponseEntity.ok(newSurgery);
    }

    @PutMapping("/{surgId}")
    public ResponseEntity<Surgery> updateSurgery(
            @PathVariable Long surgId,
            @RequestBody Surgery surgeryDetails) {
        Surgery updatedSurgery = surgeryService.updateSurgery(surgId, surgeryDetails);
        return ResponseEntity.ok(updatedSurgery);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurgery(@PathVariable Long id) {
        surgeryService.deleteSurgery(id);
        return ResponseEntity.noContent().build();
    }

    // Get surgeries by date
    @GetMapping("/today")
    public List<Surgery> getTodaySurgeries() {
        return surgeryService.getSurgeriesByDate();
    }
}