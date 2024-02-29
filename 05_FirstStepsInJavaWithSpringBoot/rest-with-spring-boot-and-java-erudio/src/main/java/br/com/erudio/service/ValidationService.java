package br.com.erudio.service;

import java.util.List;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.utils.numbersValidations;

public class ValidationService {
	
	public void processOperationValidation(String operationType, List<String> numbers) {
		switch (operationType) {
		case "sum":
			for(String number:numbers) {
				verifyNumericNumber(number);
			}
			break;
		case "subtraction":
			for(String number:numbers) {
				verifyNumericNumber(number);
			}
			break;
		case "multiplication":
			for(String number:numbers) {
				verifyNumericNumber(number);
			}
			break;
		case "division":
			for(String number:numbers) {
				verifyNumericNumber(number);
			}
			divisionByZero(numbers.get(1));
			break;
		case "avarage":
			for(String number:numbers) {
				verifyNumericNumber(number);
			}
			break;
		case "squareRoot":
			for(String number:numbers) {
				verifyNumericNumber(number);
				squareRootByNegativeNumber(number);
			}
			break;
		}
	}
	
	
	public void verifyNumericNumber(String number){
		if(!numbersValidations.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	}
	
	public void divisionByZero(String number){
		if(!numbersValidations.isZero(number)) {
			throw new UnsupportedMathOperationException("You can't divide a number by 0");
		}
	}
	
	public void squareRootByNegativeNumber(String number){
		if(!numbersValidations.lessThanZero(number)) {
			throw new UnsupportedMathOperationException("You can't do the square root of a negative number");
		}
	}

}
