package by.novitsky.simple_user_db.console_command_action;

import java.util.List;

import by.novitsky.simple_user_db.dao.AccessUserDB;
import by.novitsky.simple_user_db.entity.Role;
import by.novitsky.simple_user_db.entity.User;
import by.novitsky.simple_user_db.entity.User.UserBuilder;
import by.novitsky.simple_user_db.io_console.ConsoleIO;

public class CreateUserAction implements ConsoleAction {

	@Override
	public void act(List<User> userDB) {
		
		ConsoleIO consoleIO = ConsoleIO.get();
		UserBuilder newUser = new UserBuilder();
		
		String name = consoleIO.nameInput();
		newUser.setName(name);
		
		String secondName = consoleIO.secondNameInput();
		newUser.setSecondName(secondName);
		
		String email = consoleIO.emailInput();
		newUser.setEmail(email);
				
		Role [] roles = consoleIO.rolesInput();
		newUser.setRole(roles);
		
		String [] phones = consoleIO.phonesInput();
		newUser.setPhoneNumber(phones);
		
		User user = newUser.build();
		userDB.add(user);

		AccessUserDB.saveDB(userDB);
		
	}

}
