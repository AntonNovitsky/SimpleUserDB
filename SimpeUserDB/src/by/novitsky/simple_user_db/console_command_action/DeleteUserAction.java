package by.novitsky.simple_user_db.console_command_action;

import static by.novitsky.simple_user_db.constants.Constant.ASK_USER_INDEX;

import java.util.List;

import by.novitsky.simple_user_db.dao.AccessUserDB;
import by.novitsky.simple_user_db.entity.User;
import by.novitsky.simple_user_db.io_console.ConsoleIO;

public class DeleteUserAction implements ConsoleAction {

	@Override
	public void act(List<User> userDB) {
		
		ConsoleIO consoleio = ConsoleIO.get();
		consoleio.printUserDB(userDB);
		System.out.println(ASK_USER_INDEX);
		int index = consoleio.getNumberFormConsole(0, userDB.size());
		userDB.remove(index);
		AccessUserDB.saveDB(userDB);
		
	}

}
