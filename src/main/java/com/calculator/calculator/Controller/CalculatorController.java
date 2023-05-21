package com.calculator.calculator.Controller;

import com.calculator.calculator.Service.CalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculationService calculationService;

    public CalculatorController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/calculator")

    public String salute() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/calculator/plus")

    public String plus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        int result = calculationService.plus(a, b);
        return String.format("%s + %s = %s", a, b, result);
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam("num1")int a, @RequestParam("num2")int b) {
        int result = calculationService.minus(a, b);
        return String.format("%s - %s = %s", a, b, result);
    }

    @GetMapping("/calculator/multiply")

    public String multiply(@RequestParam("num1")int a, @RequestParam("num2")int b) {
        int result = calculationService.multiply(a, b);
        return String.format("%s * %s = %s", a, b, result);
    }

    @GetMapping("/calculator/divide")

    public String divide(@RequestParam("num1")int a, @RequestParam("num2")int b) {
        if (b == 0) {
            return "Нельзя делить на ноль";
        }
        int result = calculationService.divide(a, b);
        return String.format("%s / %s = %s", a, b, result);
    }
}

