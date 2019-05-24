package by.novitsky.simple_user_db.constants;

public abstract class Constant {
	public static final String WELCOME_MESSAGE = "Welcome to SimpleUserDB";
	public static final String USE_OR_CREATE_DB_QUESTION;
	public static final String ERROR_INVALID_INPUT = "Invalid input, please try again";
	public static final String ERROR_INVALID_EMAIL = "Invalid email format, please try again";
	public static final String ERROR_INVALID_ROLE = "Invalid role, please try again";
	public static final String ERROR_INVALID_PHONE = "Invalid phone format, required 375** *******, please try again";
	public static final String CHOOSE_DB_WORKING_OPTION = "Please choose the option below:";
	public static final String DB_WORKING_OPTION_CREATE_USER;
	public static final String DB_WORKING_OPTION_ALTER_USER;
	public static final String DB_WORKING_OPTION_DELETE_USER;
	public static final String DB_WORKING_OPTION_GET_USER_INFO;
	public static final String DB_WORKING_OPTION_EXIT;
	public static final String ASK_NAME_INPUT = "Please enter name";
	public static final String ASK_SECOND_NAME_INPUT = "Please enter second name";
	public static final String ASK_EMAIL_INPUT = "Please enter email";
	public static final String ASK_NUMBER_OF_ROLES = "Please enter number of roles";
	public static final String ASK_ROLE = "Please enter role";
	public static final String ASK_NUMBER_OF_PHONES = "Please enter number of phones";
	public static final String ASK_PHONE = "Please enter phone";
	public static final String ASK_USER_INDEX = "Please enter user index from table above";
	public static final String ASK_ALTER_NAME = "Do you want to change name?";
	public static final String ASK_ALTER_SECOND_NAME = "Do you want to change  second name?";
	public static final String ASK_ALTER_EMAIL = "Do you want to change email?";
	public static final String ASK_ALTER_ROLE = "Do you want to change roles?";
	public static final String ASK_ALTER_PHONES = "Do you want to change phone(s)?";
	public static final String YES_NO_QUESTION = " (1) yes (2) no";
	public static final String GOODBYE_MESSAGE = "Thank you for using my product!";
	public static final int CREATE_DB_CODE = 1;
	public static final int USE_DB_CODE = 2;
	public static final int CREATE_USER_CODE = 1;
	public static final int ALTER_USER_CODE = 2;
	public static final int DELETE_USER_CODE = 3;
	public static final int GET_USER_INFO_CODE = 4;
	public static final int EXIT_PROGRAM_CODE = 5;
	public static final int YES_CODE = 1;
	public static final int NO_CODE = 2;
	public static final int MIN_NUMBER_OF_ROLES_OR_PHONES = 1;
	public static final int MAX_NUMBER_OF_ROLES_OR_PHONES = 3;
	public static final String [] DB_WORKING_OPTIONS;
	
	
	static {
		USE_OR_CREATE_DB_QUESTION = "Do you want to create new DB (" + CREATE_DB_CODE + ") or use existig DB (" + USE_DB_CODE + ") ";
		DB_WORKING_OPTION_CREATE_USER = "(" + CREATE_USER_CODE + ") Create new user";
		DB_WORKING_OPTION_ALTER_USER = "(" + ALTER_USER_CODE + ") Change user data";
		DB_WORKING_OPTION_DELETE_USER = "(" + DELETE_USER_CODE + ") Delete user";
		DB_WORKING_OPTION_GET_USER_INFO = "(" + GET_USER_INFO_CODE + ") Get user info";
		DB_WORKING_OPTION_EXIT = "(" + EXIT_PROGRAM_CODE + ") Exit program";
		String [] temp = {DB_WORKING_OPTION_CREATE_USER, DB_WORKING_OPTION_ALTER_USER, DB_WORKING_OPTION_DELETE_USER, DB_WORKING_OPTION_GET_USER_INFO, DB_WORKING_OPTION_EXIT};
		DB_WORKING_OPTIONS = temp;
	}
}
