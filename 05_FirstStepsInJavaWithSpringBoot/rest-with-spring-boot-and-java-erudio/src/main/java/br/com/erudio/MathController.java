package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return covertToDouble(numberOne) + covertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return covertToDouble(numberOne) - covertToDouble(numberTwo);	
		}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return covertToDouble(numberOne) * covertToDouble(numberTwo);	
		}
	
	@RequestMapping(value = "/division/{dividend}/{divider}",method=RequestMethod.GET)
	public Double division(
			@PathVariable(value="dividend") String dividend, 
			@PathVariable(value="divider") String divider
			) throws Exception{
		if(!isNumeric(dividend) || !isNumeric(divider)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}if(isZero(divider)) {
			throw new UnsupportedMathOperationException("You can't divide a number by 0");
		}
		return covertToDouble(dividend) / covertToDouble(divider);	
		}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double average(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return covertToDouble(numberOne) + covertToDouble(numberTwo) / 2;	
		}
	
	@RequestMapping(value = "/squareRoot/{numberOne}",method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value="numberOne") String numberOne
			) throws Exception{
		if(!isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		if(lessThanZero(numberOne)) {
			throw new UnsupportedMathOperationException("You can't do the square root of a negative number");
		}
		return Math.sqrt(covertToDouble(numberOne));
		}
	
	
	public static Double covertToDouble(String number) {
		if(number ==null) return 0D;
		String finalNumber = number.replace(",", ".");
		if(isNumeric(finalNumber)) return Double.parseDouble(finalNumber);
		return 1.0D;
	}

	public static boolean isNumeric(String number) {
		if(number ==null) return false;
		String finalNumber = number.replace(",", ".");
		return finalNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static boolean isZero(String number) {
		if(covertToDouble(number) == 0) return true;
		return false;
	}
	
	public static boolean lessThanZero(String number) {
		if(covertToDouble(number) < 0) return true;
		return false;
	}
	
}
