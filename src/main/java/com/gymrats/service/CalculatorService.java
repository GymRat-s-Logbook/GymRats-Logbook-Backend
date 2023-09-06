package com.gymrats.service;

import com.gymrats.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalculatorService {

    public BmiNotLoggedResponse calculateBmi(BmiNotLoggedRequest requestBmi) {
        float weight = requestBmi.weight();
        float height = requestBmi.height()/100;
        float bmi = weight / (height * height);
        return new BmiNotLoggedResponse(bmi);
    }

    public BmrNotLoggedResponse calculateBmr(BmrNotLoggedRequest requestDataBmr){
        int yearOfBirth = requestDataBmr.dateOfBirth().getYear();
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int userAge = currentYear - yearOfBirth;
        GenderEnum sex = requestDataBmr.sex();
        float weight = requestDataBmr.weight();
        float height = requestDataBmr.height();
        float bmr;

        if(sex.equals(GenderEnum.WOMAN)){
            bmr = (float)(447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * userAge));
        } else {
            bmr = (float)(88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * userAge));
        }
        return new BmrNotLoggedResponse(bmr);
    }
}