package br.com.spring.project.Controllers;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import br.com.spring.project.Exceptions.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MathController {
    private String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable( "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws UnsupportedMathOperationException {

            if(Objects.isNull(numberOne) || Objects.isNull(numberOne) || !isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please set a numeric value.");
            }

            return convertToDouble(numberOne) + convertToDouble(numberTwo);
        }

    private Double convertToDouble(String numberString) {
        return Double.parseDouble(numberString);
    }

    private boolean isNumeric(String numberString) {
        try {  
            Double.parseDouble(numberString);
            return true;
        } catch(NumberFormatException e){  
            return false;  
        } 
    }
 
}
