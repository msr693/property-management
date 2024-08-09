package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.CalculatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
        return num1+num2;

    }

    @PostMapping("/multiply")
    public ResponseEntity multiply(@RequestBody CalculatorDto calculatorDto){
        Double result = null;
        result = calculatorDto.getNum1()*calculatorDto.getNum2()* calculatorDto.getNum3()* calculatorDto.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
