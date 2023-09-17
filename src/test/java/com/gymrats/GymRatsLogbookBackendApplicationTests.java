package com.gymrats;

import com.gymrats.model.BmiNotLoggedRequest;
import com.gymrats.model.BmiNotLoggedResponse;
import com.gymrats.model.BmrNotLoggedRequest;
import com.gymrats.model.BmrNotLoggedResponse;
import com.gymrats.model.GenderEnum;
import com.gymrats.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void shouldReturnBmrForWoman() {
        //given
        LocalDate dateOfBirthExample = LocalDate.of(2002, 02,2);
        BmrNotLoggedRequest dataToCalculateBmr = new BmrNotLoggedRequest(GenderEnum.WOMAN, dateOfBirthExample, 60, 170);
        //when
        BmrNotLoggedResponse bmrResult = service.calculateBmr(dataToCalculateBmr);
        //then
        assertEquals(1438.14, Math.floor(bmrResult.bmrResponse() * 100.0f) / 100.0f);
    }

    @Test
    void shouldReturnBmrForMan() {
        //given
        LocalDate dateOfBirthExample = LocalDate.of(2002, 02,2);
        BmrNotLoggedRequest dataToCalculateBmr = new BmrNotLoggedRequest(GenderEnum.MAN, dateOfBirthExample, 60, 170);
        //when
        BmrNotLoggedResponse bmrResult = service.calculateBmr(dataToCalculateBmr);
        //then
        assertEquals(1588.79, Math.floor(bmrResult.bmrResponse() * 100.0f) / 100.0f);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenWeightIsZero() {
        //given
        LocalDate dateOfBirthExample = LocalDate.of(2002, 02,2);
        BmrNotLoggedRequest bmrZero = new BmrNotLoggedRequest(GenderEnum.WOMAN, dateOfBirthExample, 0, 180);
        //when
        //then
        assertThrows(IllegalArgumentException.class, ()-> service.calculateBmr(bmrZero));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenHeightIsZero() {
        //given
        LocalDate dateOfBirthExample = LocalDate.of(2002, 02,2);
        BmrNotLoggedRequest bmrZero = new BmrNotLoggedRequest(GenderEnum.WOMAN, dateOfBirthExample, 60, 0);
        //when
        //then
        assertThrows(IllegalArgumentException.class, ()-> service.calculateBmr(bmrZero));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenAgeIsZero() {
        //given
        LocalDate dateOfBirthExample = LocalDate.now();
        BmrNotLoggedRequest bmrZero = new BmrNotLoggedRequest(GenderEnum.MAN, dateOfBirthExample, 60, 180);
        //when
        //then
        assertThrows(IllegalArgumentException.class, ()-> service.calculateBmr(bmrZero));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenWeightIsNegative() {
        //given
        LocalDate dateOfBirthExample = LocalDate.of(2002, 02,2);
        BmrNotLoggedRequest bmrZero = new BmrNotLoggedRequest(GenderEnum.WOMAN, dateOfBirthExample, -10, 180);
        //when
        //then
        assertThrows(IllegalArgumentException.class, ()-> service.calculateBmr(bmrZero));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenHeightIsNegative() {
        //given
        LocalDate dateOfBirthExample = LocalDate.of(2002, 02,2);
        BmrNotLoggedRequest bmrZero = new BmrNotLoggedRequest(GenderEnum.WOMAN, dateOfBirthExample, 60, -100);
        //when
        //then
        assertThrows(IllegalArgumentException.class, ()-> service.calculateBmr(bmrZero));
    }

}
