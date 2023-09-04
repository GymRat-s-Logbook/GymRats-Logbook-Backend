package com.gymrats.service.CalculatorService;

import com.gymrats.Dto.BmiNotLoggedRequest.BmiNotLoggedRequest;
import com.gymrats.Dto.BmiNotLoggedResponse.BmiNotLoggedResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    float bmi;
    float weight;
    float height;

    public BmiNotLoggedResponse calculateBmi(BmiNotLoggedRequest requestBmi) {
        weight = requestBmi.weight();
        height= requestBmi.height();
        bmi = weight / (height * height);
        BmiNotLoggedResponse bmiResponse = new BmiNotLoggedResponse(bmi);
        System.out.println("serwis");
        return bmiResponse;
    }

}
