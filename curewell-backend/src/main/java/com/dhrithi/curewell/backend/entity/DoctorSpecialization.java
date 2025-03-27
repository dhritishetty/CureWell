package com.dhrithi.curewell.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DoctorSpecialization")
public class DoctorSpecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "specializationCode", referencedColumnName = "specCode", nullable = false)
    private Specialization specialization;

    @Column(nullable = false)
    private LocalDate specializationDate;

    public DoctorSpecialization() {}

    public DoctorSpecialization(Doctor doctor, Specialization specialization, LocalDate specializationDate) {
        this.doctor = doctor;
        this.specialization = specialization;
        this.specializationDate = specializationDate;
    }

    public Long getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Specialization getSpecialisation() {
        return specialization;
    }

    public LocalDate getSpecializationDate() {
        return specializationDate;
    }
}
