package com.gymrats.model;

public record BmiNotLoggedResponse(float bmi) {
    public BmiNotLoggedResponse(float bmi) {
        this.bmi = bmi;
    }

    public float bmi() {
        return this.bmi;
    }
}
