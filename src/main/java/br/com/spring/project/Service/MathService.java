package br.com.spring.project.Service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.spring.project.Exceptions.UnsupportedMathOperationException;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) throws UnsupportedMathOperationException {

        if(Objects.isNull(numberOne) || Objects.isNull(numberOne) || !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double subtration(String numberOne, String numberTwo) throws UnsupportedMathOperationException {

        if(Objects.isNull(numberOne) || Objects.isNull(numberOne) || !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) throws UnsupportedMathOperationException {

        if(Objects.isNull(numberOne) || Objects.isNull(numberOne) || !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) throws UnsupportedMathOperationException {

        if(Objects.isNull(numberOne) || Objects.isNull(numberOne) || !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public Double multiplication(String numberOne, String numberTwo) throws UnsupportedMathOperationException {

        if(Objects.isNull(numberOne) || Objects.isNull(numberOne) || !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
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
