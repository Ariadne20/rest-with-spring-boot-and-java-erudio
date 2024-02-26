package br.com.erudio.utils;

public class numbersValidations {
	
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
