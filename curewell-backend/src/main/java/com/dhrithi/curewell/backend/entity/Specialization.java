package com.dhrithi.curewell.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Specialization")
public class Specialization {

    @Id
    @Column(length = 3)
    private String specCode;

    @Column(nullable = false)
    private String specName;

    public Specialization() {}

    public Specialization(String specCode, String specName) {
        this.specCode = specCode;
        this.specName = specName;
    }

    public String getSpecCode() {
        return specCode;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}
