package com.gymrats.service;

import com.gymrats.model.BmiNotLoggedRequest;
import com.gymrats.model.BmiNotLoggedResponse;
import com.gymrats.model.BmrNotLoggedRequest;
import com.gymrats.model.BmrNotLoggedResponse;
import com.gymrats.model.GenderEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculatorService {

    public BmiNotLoggedResponse calculateBmi(BmiNotLoggedRequest requestBmi) {
        float weight = requestBmi.weight();
        float height = requestBmi.height()/100;
        float bmi = weight / (height * height);
        return new BmiNotLoggedResponse(bmi);
    }

    public BmrNotLoggedResponse calculateBmr(BmrNotLoggedRequest requestBmr){

        int userAge = Period.between(requestBmr.dateOfBirth(), LocalDate.now()).getYears();
        GenderEnum sex = requestBmr.sex();
        float weight = requestBmr.weight();
        float height = requestBmr.height();
        float bmr = 0;

        if(weight == 0 || weight < 0 || height == 0 || height < 0  || userAge == 0 || userAge < 0){
            throw new IllegalArgumentException();
        }
        else if(sex.equals(GenderEnum.WOMAN)){
            bmr = (float)(447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * userAge));
        }else if (sex.equals(GenderEnum.MAN)){
            bmr = (float)(88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * userAge));
        }
        return new BmrNotLoggedResponse(bmr);
    }
}