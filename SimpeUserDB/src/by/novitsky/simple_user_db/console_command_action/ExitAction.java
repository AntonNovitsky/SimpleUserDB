package by.novitsky.simple_user_db.console_command_action;

import java.util.List;

import by.novitsky.simple_user_db.entity.User;
import by.novitsky.simple_user_db.io_console.ConsoleIO;
import static by.novitsky.simple_user_db.constants.Constant.GOODBYE_MESSAGE;

public class ExitAction implements ConsoleAction {

	@Override
	public void act(List<User> userDB) {
		ConsoleIO consoleio = ConsoleIO.get();
		consoleio.printMessage(GOODBYE_MESSAGE);
		System.exit(0);
	}

}
