package com.gymrats;

import com.gymrats.model.BmiNotLoggedRequest;
import com.gymrats.model.BmiNotLoggedResponse;
import com.gymrats.model.GenderEnum;
import com.gymrats.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GymRatsLogbookBackendApplicationTests {

    private final CalculatorService service = new CalculatorService();

    @Test
    void shouldReturnBmi() {
        //given
        BmiNotLoggedRequest dataToCalculateBmi = new BmiNotLoggedRequest(GenderEnum.WOMAN, 60.0F, 170.0F);
        //when
        BmiNotLoggedResponse result = this.service.calculateBmi(dataToCalculateBmi);
        //then
        assertEquals(0.0, result.bmi());
    }
}
