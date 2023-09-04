package com.gymrats;

import com.gymrats.model.BmiNotLoggedRequest;
import com.gymrats.model.BmiNotLoggedResponse;
import com.gymrats.model.GenderEnum;
import com.gymrats.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GymRatsLogbookBackendApplicationTests {

    CalculatorService service = new CalculatorService();

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnBmi() {
        BmiNotLoggedRequest dataToCalculateBmi = new BmiNotLoggedRequest(GenderEnum.WOMAN, 60.0F, 170.0F);
        BmiNotLoggedResponse result = this.service.calculateBmi(dataToCalculateBmi);
        Assertions.assertEquals(0.0020761245395988226, result.bmi());
    }
}
