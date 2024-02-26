package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.service.MathService;
import br.com.erudio.utils.numbersValidations;

@RestController
public class MathController {
	
	MathService service = new MathService();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		return service.sum(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
		
		return service.subtraction(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
	
		return service.multiplication(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/division/{dividend}/{divider}",method=RequestMethod.GET)
	public Double division(
			@PathVariable(value="dividend") String dividend, 
			@PathVariable(value="divider") String divider
			) throws Exception{
		
		return service.division(dividend, divider);
	}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double average(
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception{
		
		return service.average(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/squareRoot/{numberOne}",method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value="numberOne") String numberOne
			) throws Exception{
		
		return service.squareRoot(numberOne);
	}
	
}
