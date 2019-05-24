package by.novitsky.simple_user_db.console_command_action;

import static by.novitsky.simple_user_db.constants.Constant.ASK_ALTER_EMAIL;
import static by.novitsky.simple_user_db.constants.Constant.ASK_ALTER_NAME;
import static by.novitsky.simple_user_db.constants.Constant.ASK_ALTER_PHONES;
import static by.novitsky.simple_user_db.constants.Constant.ASK_ALTER_ROLE;
import static by.novitsky.simple_user_db.constants.Constant.ASK_ALTER_SECOND_NAME;
import static by.novitsky.simple_user_db.constants.Constant.ASK_USER_INDEX;

import java.util.List;

import by.novitsky.simple_user_db.dao.AccessUserDB;
import by.novitsky.simple_user_db.entity.Role;
import by.novitsky.simple_user_db.entity.User;
import by.novitsky.simple_user_db.io_console.ConsoleIO;

public class AlterUserAction implements ConsoleAction{

	@Override
	public void act(List<User> userDB) {
		
		ConsoleIO consoleIO = ConsoleIO.get();
		consoleIO.printUserDB(userDB);
		System.out.println(ASK_USER_INDEX);
		int userIndex = consoleIO.getNumberFormConsole(0, userDB.size());
		User user = userDB.get(userIndex);
		System.out.println(user);
		if (consoleIO.generalQuestionInput(ASK_ALTER_NAME)) {
			String name = consoleIO.nameInput();
			user.setName(name);
		}
		if (consoleIO.generalQuestionInput(ASK_ALTER_SECOND_NAME)) {
			String secondName = consoleIO.secondNameInput();
			user.setSecondName(secondName);
		}
		if (consoleIO.generalQuestionInput(ASK_ALTER_EMAIL)) {
			String email = consoleIO.emailInput();
			user.setEmail(email);
		}
		if (consoleIO.generalQuestionInput(ASK_ALTER_ROLE)) {
			Role[] role = consoleIO.rolesInput();
			user.setRole(role);
		}
		if (consoleIO.generalQuestionInput(ASK_ALTER_PHONES)) {
			String[] phone = consoleIO.phonesInput();
			user.setPhoneNumber(phone);
		}
		
		AccessUserDB.saveDB(userDB);
		
	}
	
	

}
