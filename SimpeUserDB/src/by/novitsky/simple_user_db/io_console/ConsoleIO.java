package by.novitsky.simple_user_db.io_console;

import static by.novitsky.simple_user_db.constants.Constant.ASK_EMAIL_INPUT;
import static by.novitsky.simple_user_db.constants.Constant.ASK_NAME_INPUT;
import static by.novitsky.simple_user_db.constants.Constant.ASK_NUMBER_OF_PHONES;
import static by.novitsky.simple_user_db.constants.Constant.ASK_NUMBER_OF_ROLES;
import static by.novitsky.simple_user_db.constants.Constant.ASK_PHONE;
import static by.novitsky.simple_user_db.constants.Constant.ASK_ROLE;
import static by.novitsky.simple_user_db.constants.Constant.ASK_SECOND_NAME_INPUT;
import static by.novitsky.simple_user_db.constants.Constant.ERROR_INVALID_EMAIL;
import static by.novitsky.simple_user_db.constants.Constant.ERROR_INVALID_INPUT;
import static by.novitsky.simple_user_db.constants.Constant.ERROR_INVALID_PHONE;
import static by.novitsky.simple_user_db.constants.Constant.ERROR_INVALID_ROLE;
import static by.novitsky.simple_user_db.constants.Constant.MAX_NUMBER_OF_ROLES_OR_PHONES;
import static by.novitsky.simple_user_db.constants.Constant.MIN_NUMBER_OF_ROLES_OR_PHONES;
import static by.novitsky.simple_user_db.constants.Constant.NO_CODE;
import static by.novitsky.simple_user_db.constants.Constant.YES_CODE;
import static by.novitsky.simple_user_db.constants.Constant.YES_NO_QUESTION;

import java.util.List;
import java.util.Scanner;

import by.novitsky.simple_user_db.entity.Role;
import by.novitsky.simple_user_db.entity.User;
import by.novitsky.simple_user_db.validator.Validator;

public class ConsoleIO {
	
	private static final Scanner CONSOLE_SCANNER = new Scanner(System.in);
	
	private static final ConsoleIO CONSOLE_IO;
	
	private static final String ROLE_LIST = "Role list defined as:";
	
	
	static {
		CONSOLE_IO = new ConsoleIO();
	}
	
	public static ConsoleIO get() {
		return CONSOLE_IO;
	}
	
	public int getNumberFormConsole(int min, int max) {
		while (true) {
			if (CONSOLE_SCANNER.hasNextInt()) {
				int result = CONSOLE_SCANNER.nextInt();
				if (result <= max && result >= min) {
					return result;
				}
			}
			System.out.println(ERROR_INVALID_INPUT);
			CONSOLE_SCANNER.next();
		}
	}
	
	public boolean generalQuestionInput(String message) {
		System.out.println(message + YES_NO_QUESTION);
		int resultInt = getNumberFormConsole(YES_CODE, NO_CODE);
		if (resultInt == 1) {
			return true;
		}
		return false;
	}
	
	public String stringInput(String message) {
		System.out.println(message);
		String result = CONSOLE_SCANNER.next();
		return result;
	}
	
	public String nameInput() {
		return stringInput(ASK_NAME_INPUT);
	}
	
	public String secondNameInput() {
		return stringInput(ASK_SECOND_NAME_INPUT);
	}
	
	public String emailInput() {
		while(true) {
			System.out.println(ASK_EMAIL_INPUT);
			String email = CONSOLE_SCANNER.next();
			if (Validator.isEmailValid(email)) {
				return email;
			}
			System.out.println(ERROR_INVALID_EMAIL);
		}
	}
	
	public Role[] rolesInput() {
		System.out.println(ASK_NUMBER_OF_ROLES);
		int numberOfRoles = getNumberFormConsole(MIN_NUMBER_OF_ROLES_OR_PHONES, MAX_NUMBER_OF_ROLES_OR_PHONES);
		Role [] roles = getRolesArray(numberOfRoles);
		return roles;
	}
	
	public String[] phonesInput() {
		System.out.println(ASK_NUMBER_OF_PHONES);
		int numberOfPhones = getNumberFormConsole(MIN_NUMBER_OF_ROLES_OR_PHONES, MAX_NUMBER_OF_ROLES_OR_PHONES);
		String [] phones = getPhonesArray(numberOfPhones);
		return phones;
	}
	
	public String[] getPhonesArray(int numberOfPhones) {
		String [] result = new String[numberOfPhones];
		String inputPhone = "";
		for (int i = 0; i < numberOfPhones;) {
			while (true) {
				System.out.println(ASK_PHONE);
				inputPhone = CONSOLE_SCANNER.nextLine();
				if ("".equals(inputPhone)) {
					continue;
				}
				if (Validator.isPhoneNumberValid(inputPhone)) {
					result[i] = inputPhone;
					i++;
					if (i == numberOfPhones) {
						return result;
					}
				} else {
					System.out.println(ERROR_INVALID_PHONE);
				}
			}
		}
		return result;
	}
	
	private static void printRoles() {
		System.out.println(ROLE_LIST);
		Role [] roles = Role.values();
		for (int i = 0; i < roles.length; i++) {
			System.out.println(i + ") " + roles[i].getNameOfRole());
		}
	}
	
	public Role[] getRolesArray(int numberOfRoles) {
		Role [] roles = new Role [numberOfRoles];
		int i = 0;
			while (true) {
				System.out.println(ASK_ROLE);
				printRoles();
				String inputRole = CONSOLE_SCANNER.next();
				if (Validator.isRoleValid(inputRole)) {
					roles[i] = Role.findByNameOfRole(inputRole);
					i++;
					if (i == numberOfRoles) {
						return roles;
					}
				} else {
					System.out.println(ERROR_INVALID_ROLE);
				}
			}
	}
	
	public void printDivider() {
		System.out.println("--------------------------------------");
	}
	
	public void printUserDB(List<User> userDB) {
		
		this.printDivider();
		for (int i = 0; i < userDB.size(); i++) {
			System.out.println(i + " - " + userDB.get(i));
		}
		this.printDivider();
		
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}

}
