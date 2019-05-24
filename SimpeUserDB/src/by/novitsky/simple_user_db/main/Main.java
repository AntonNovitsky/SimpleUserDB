package by.novitsky.simple_user_db.main;

import static by.novitsky.simple_user_db.constants.Constant.*;

import java.util.List;

import by.novitsky.simple_user_db.console_command_action.AlterUserAction;
import by.novitsky.simple_user_db.console_command_action.ConsoleAction;
import by.novitsky.simple_user_db.console_command_action.CreateUserAction;
import by.novitsky.simple_user_db.console_command_action.DeleteUserAction;
import by.novitsky.simple_user_db.console_command_action.ExitAction;
import by.novitsky.simple_user_db.console_command_action.GetUserInfoAction;
import by.novitsky.simple_user_db.dao.EmptyDBFactory;
import by.novitsky.simple_user_db.dao.FactoryDB;
import by.novitsky.simple_user_db.dao.LoadDBFactory;
import by.novitsky.simple_user_db.entity.User;
import by.novitsky.simple_user_db.io_console.ConsoleIO;

public class Main {
	
	
	private static ConsoleIO consoleIO = ConsoleIO.get();

	public static void main(String[] args) {
		
		consoleIO.printMessage(WELCOME_MESSAGE);
		List<User> userDB = getDB();
		operateDB(userDB);

	}
	
	private static void operateDB(List<User> userDB) {
		while (true) {
			consoleIO.printUserDB(userDB);
			System.out.println(CHOOSE_DB_WORKING_OPTION);
			for (String option: DB_WORKING_OPTIONS) {
				System.out.println(option);
				}
			
			int chosenOptionCode = consoleIO.getNumberFormConsole(1,5);
			ConsoleAction action = null;
			switch (chosenOptionCode) {
			case CREATE_USER_CODE:
				action = new CreateUserAction();
				break;
			case ALTER_USER_CODE:
				action = new AlterUserAction();
				break;
			case DELETE_USER_CODE:
				action = new DeleteUserAction();
				break;
			case GET_USER_INFO_CODE:
				action = new GetUserInfoAction();
				break;
			case EXIT_PROGRAM_CODE:
				action = new ExitAction();
			}
			action.act(userDB);
		}
	}
	
		
	private static List<User> getDB() {
			consoleIO.printMessage(USE_OR_CREATE_DB_QUESTION);
			int chosenOptionCode = consoleIO.getNumberFormConsole(1, 2);
			FactoryDB factory = chooseFactory(chosenOptionCode);
			return factory.getDB();
	}
	
	private static FactoryDB chooseFactory(int chosenOptionCode) {
		switch (chosenOptionCode) {
		case CREATE_DB_CODE:
			return new EmptyDBFactory();
		case USE_DB_CODE:
			return new LoadDBFactory();
		}
		throw new RuntimeException("Trying to create unnown object");
	}
	
}
