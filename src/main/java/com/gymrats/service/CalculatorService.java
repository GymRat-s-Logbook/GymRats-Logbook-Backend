package com.gymrats.service;

import com.gymrats.model.BmiNotLoggedRequest;
import com.gymrats.model.BmiNotLoggedResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {


    public BmiNotLoggedResponse calculateBmi(BmiNotLoggedRequest requestBmi) {
        float weight = requestBmi.weight();
        float height = requestBmi.height();
        float bmi = weight / (height * height);
        BmiNotLoggedResponse bmiResponse = new BmiNotLoggedResponse(bmi);
        return bmiResponse;
    }
}