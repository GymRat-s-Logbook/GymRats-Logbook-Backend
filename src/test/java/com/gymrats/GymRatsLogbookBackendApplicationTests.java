package com.gymrats;

import com.gymrats.model.*;
import com.gymrats.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GymRatsLogbookBackendApplicationTests {

    private final CalculatorService service = new CalculatorService();

    @Test
    void shouldReturnBmi() {
        //given
        BmiNotLoggedRequest dataToCalculateBmi = new BmiNotLoggedRequest(60.0F, 170.0F);
        //when
        BmiNotLoggedResponse result = service.calculateBmi(dataToCalculateBmi);
        //then
        assertEquals(20.76, Math.floor(result.bmi() * 100.0f) / 100.0f);
    }

    @Test
    void shouldReturnBmr() {
        //given
        LocalDate dateOfBirthExample = LocalDate.of(2002, 02,2);
        BmrNotLoggedRequest dataToCalculateBmr = new BmrNotLoggedRequest(GenderEnum.WOMAN, dateOfBirthExample, 60, 170);
        //when
        BmrNotLoggedResponse bmrResult = service.calculateBmr(dataToCalculateBmr);
        //then
        assertEquals(1438.14, Math.floor(bmrResult.bmrResponse() * 100.0f) / 100.0f);
    }
}
