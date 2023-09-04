package com.gymrats.controller;

import com.gymrats.model.BmiNotLoggedRequest;
import com.gymrats.model.BmiNotLoggedResponse;
import com.gymrats.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/bmi")
    public ResponseEntity<BmiNotLoggedResponse> calculateBmi(@RequestBody BmiNotLoggedRequest requestBmi) {
        BmiNotLoggedResponse bmiNotLoggedResponse = calculatorService.calculateBmi(requestBmi);
        return ResponseEntity.ok(bmiNotLoggedResponse);
    }
}
