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
}
