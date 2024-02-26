package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.utils.numbersValidations;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!numbersValidations.isNumeric(numberOne) || !numbersValidations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return numbersValidations.covertToDouble(numberOne) + numbersValidations.covertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
		if(!numbersValidations.isNumeric(numberOne) || !numbersValidations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return numbersValidations.covertToDouble(numberOne) - numbersValidations.covertToDouble(numberTwo);	
		}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
		if(!numbersValidations.isNumeric(numberOne) || !numbersValidations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return numbersValidations.covertToDouble(numberOne) * numbersValidations.covertToDouble(numberTwo);	
		}
	
	@RequestMapping(value = "/division/{dividend}/{divider}",method=RequestMethod.GET)
	public Double division(
			@PathVariable(value="dividend") String dividend, 
			@PathVariable(value="divider") String divider
			) throws Exception{
		if(!numbersValidations.isNumeric(dividend) || !numbersValidations.isNumeric(divider)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}if(numbersValidations.isZero(divider)) {
			throw new UnsupportedMathOperationException("You can't divide a number by 0");
		}
		return numbersValidations.covertToDouble(dividend) / numbersValidations.covertToDouble(divider);	
		}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double average(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
		if(!numbersValidations.isNumeric(numberOne) || !numbersValidations.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return numbersValidations.covertToDouble(numberOne) + numbersValidations.covertToDouble(numberTwo) / 2;	
		}
	
	@RequestMapping(value = "/squareRoot/{numberOne}",method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value="numberOne") String numberOne
			) throws Exception{
		if(!numbersValidations.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		if(numbersValidations.lessThanZero(numberOne)) {
			throw new UnsupportedMathOperationException("You can't do the square root of a negative number");
		}
		return Math.sqrt(numbersValidations.covertToDouble(numberOne));
		}
	
}
