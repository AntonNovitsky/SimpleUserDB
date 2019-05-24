package by.novitsky.simple_user_db.console_command_action;

import java.util.List;

import by.novitsky.simple_user_db.entity.User;

public interface ConsoleAction {
	
	public void act(List<User> userDB);

}
