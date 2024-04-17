package br.com.spring.project.Controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.spring.project.Exceptions.UnsupportedMathOperationException;
import br.com.spring.project.Services.MathService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable( "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws UnsupportedMathOperationException {

        Double result = mathService.sum(numberOne, numberTwo);
        return result;
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
        @PathVariable( "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws UnsupportedMathOperationException {

        Double result = mathService.subtration(numberOne, numberTwo);
        return result;
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
        @PathVariable( "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws UnsupportedMathOperationException {

        Double result = mathService.multiplication(numberOne, numberTwo);
        return result;
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
        @PathVariable( "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws UnsupportedMathOperationException {

        Double result = mathService.division(numberOne, numberTwo);
        return result;    
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
        @PathVariable( "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws UnsupportedMathOperationException {

        Double result = mathService.mean(numberOne, numberTwo);
        return result;  
    }
 
}
