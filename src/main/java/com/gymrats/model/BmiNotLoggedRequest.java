package com.gymrats.model;

public record BmiNotLoggedRequest(GenderEnum sex, float weight, float height) {
    public BmiNotLoggedRequest(GenderEnum sex, float weight, float height) {
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    public GenderEnum sex() {
        return this.sex;
    }

    public float weight() {
        return this.weight;
    }

    public float height() {
        return this.height;
    }
}
