package br.com.erudio.service;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.utils.numbersValidations;

public class MathService {
	
	public Double sum(String numberOne, String numberTwo) throws Exception{
		
		if(!numbersValidations.isNumeric(numberOne) || !numbersValidations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return numbersValidations.covertToDouble(numberOne) + numbersValidations.covertToDouble(numberTwo);
		
	}
	
	public  Double subtraction(String numberOne, String numberTwo) throws Exception{
		if(!numbersValidations.isNumeric(numberOne) || !numbersValidations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return numbersValidations.covertToDouble(numberOne) - numbersValidations.covertToDouble(numberTwo);	
	}
	
	public  Double multiplication(String numberOne, String numberTwo) throws Exception{
		if(!numbersValidations.isNumeric(numberOne) || !numbersValidations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return numbersValidations.covertToDouble(numberOne) * numbersValidations.covertToDouble(numberTwo);	
	}
	
	public  Double division(String dividend, String divider) throws Exception{
		if(!numbersValidations.isNumeric(dividend) || !numbersValidations.isNumeric(divider)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}if(numbersValidations.isZero(divider)) {
			throw new UnsupportedMathOperationException("You can't divide a number by 0");
		}
		return numbersValidations.covertToDouble(dividend) / numbersValidations.covertToDouble(divider);	
	}
	
	public  Double average(String numberOne, String numberTwo) throws Exception{
		if(!numbersValidations.isNumeric(numberOne) || !numbersValidations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return (numbersValidations.covertToDouble(numberOne) + numbersValidations.covertToDouble(numberTwo)) / 2;	
	}
	
	public  Double squareRoot(String numberOne) throws Exception{
		if(!numbersValidations.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		if(numbersValidations.lessThanZero(numberOne)) {
			throw new UnsupportedMathOperationException("You can't do the square root of a negative number");
		}
		return Math.sqrt(numbersValidations.covertToDouble(numberOne));
	}
}
