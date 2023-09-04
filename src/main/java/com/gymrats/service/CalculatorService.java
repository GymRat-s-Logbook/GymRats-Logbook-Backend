package com.gymrats.service;

import com.gymrats.model.BmiNotLoggedRequest;
import com.gymrats.model.BmiNotLoggedResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    float bmi;
    float weight;
    float height;

    public CalculatorService() {
    }

    public BmiNotLoggedResponse calculateBmi(BmiNotLoggedRequest requestBmi) {
        this.weight = requestBmi.weight();
        this.height = requestBmi.height();
        this.bmi = this.weight / (this.height * this.height);
        BmiNotLoggedResponse bmiResponse = new BmiNotLoggedResponse(this.bmi);
        return bmiResponse;
    }
}