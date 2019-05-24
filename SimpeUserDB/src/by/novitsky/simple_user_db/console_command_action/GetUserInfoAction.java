package by.novitsky.simple_user_db.console_command_action;

import static by.novitsky.simple_user_db.constants.Constant.ASK_USER_INDEX;

import java.util.List;

import by.novitsky.simple_user_db.entity.User;
import by.novitsky.simple_user_db.io_console.ConsoleIO;

public class GetUserInfoAction implements ConsoleAction {

	@Override
	public void act(List<User> userDB) {
		ConsoleIO consoleIO = ConsoleIO.get();
		consoleIO.printUserDB(userDB);
		System.out.println(ASK_USER_INDEX);
		int index = consoleIO.getNumberFormConsole(0, userDB.size());
		User user = userDB.get(index);
		consoleIO.printDivider();
		System.out.print(user);
		consoleIO.printDivider();		
	}

}
