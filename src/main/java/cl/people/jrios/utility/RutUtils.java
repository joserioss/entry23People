package cl.people.jrios.utility;

public class RutUtils {
	
	private RutUtils() {}
	
	
	/**
	 * Method created in a utility class to verify that the rout entered 
	 * in string format and with a check digit is true.
	 * Format invalid: 12.345.678-k 
	 * Format valid: 12345678k
	 * @param rut
	 * @return
	 */
	public static boolean isValid(String rut) {
		Integer lenght = rut.length();
		Integer bodyRut = Integer.parseInt(rut.substring(0, (lenght - 1)));
		String digitCheck = rut.substring((lenght - 1), lenght).toLowerCase();
		int serieMod11 = 2;
		int mod11 = 0;
		int resultMultiple = 0;
		boolean check = false;
		int result;
		String resultMod11;

		while (bodyRut != 0) {
			// bodyRut%10 Decompose the rut from the last digit, and multiply it by serie[2-8]
			resultMultiple = (bodyRut % 10) * serieMod11;
			mod11 += resultMultiple;
			// remove the digit already added from the rut
			bodyRut = bodyRut / 10;
			serieMod11++;
			// reset serie Mod11
			if (serieMod11 == 8)
				serieMod11 = 2;
		}
		result = 11 - (mod11 % 11);
		// RULES MOD 11
		if(result == 10)
			resultMod11 = "k";
		else if(result == 11)
			resultMod11 = "0";
		else	
			resultMod11 = Integer.toString(result);
		if (digitCheck.equals(resultMod11))
			check = true;
		return check;
	}
}
