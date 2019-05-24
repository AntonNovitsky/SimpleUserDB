package by.novitsky.simple_user_db.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.novitsky.simple_user_db.entity.Role;

public class Validator {
	
	public static boolean isEmailValid(String input) {
		Pattern p = Pattern.compile("[^@]*@[^\\.]*\\..*");
		Matcher m = p.matcher(input);
		return m.matches();
	}
	
	public static boolean isRoleValid(String input) {
		
		if (Role.findByNameOfRole(input) != null) {
			return true;
		}
		return false;
	}
	
	public static boolean isPhoneNumberValid(String input) {
		Pattern p = Pattern.compile("(375)\\d{2}\\s{1}\\d{7}");
		Matcher m = p.matcher(input);
		return m.matches();
	}

}
