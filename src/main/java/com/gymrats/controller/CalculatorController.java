package com.gymrats;

import com.gymrats.model.BmiNotLoggedRequest;
import com.gymrats.model.BmiNotLoggedResponse;
import com.gymrats.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("/api/v1")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;

    }

    @PostMapping("/bmi")
    public ResponseEntity<BmiNotLoggedResponse> calculateBmi(@RequestBody BmiNotLoggedRequest requestBmi){
        System.out.println("controller");
        BmiNotLoggedResponse bmiNotLoggedResponse = calculatorService.calculateBmi(requestBmi);
        System.out.println("przy odpowiedzi");
        return ResponseEntity.ok(bmiNotLoggedResponse);
    }



}
