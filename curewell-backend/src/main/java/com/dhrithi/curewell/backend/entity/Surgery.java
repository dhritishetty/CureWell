package com.dhrithi.curewell.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "SurgeryTable")
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SurgId;

    @Column(nullable = false)
    private String surgeryName;

    @ManyToOne
    @JoinColumn(name = "docId", nullable = false)
    private Doctor doctor;

    @Column(name = "SpecCode", nullable = false)
    private String SpecCode;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private LocalDate surgeryDate;

    public Surgery(){}

    public Surgery(Long surgId, String surgeryName, Doctor doctor, String specCode, LocalTime startTime, LocalTime endTime, LocalDate surgeryDate) {
        SurgId = surgId;
        this.surgeryName = surgeryName;
        this.doctor = doctor;
        SpecCode = specCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.surgeryDate = surgeryDate;
    }

    public Long getSurgId() {
        return SurgId;
    }

    public void setSurgId(Long surgId) {
        SurgId = surgId;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getSpecCode() {
        return SpecCode;
    }

    public void setSpecCode(String specCode) {
        SpecCode = specCode;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(LocalDate surgeryDate) {
        this.surgeryDate = surgeryDate;
    }
}
