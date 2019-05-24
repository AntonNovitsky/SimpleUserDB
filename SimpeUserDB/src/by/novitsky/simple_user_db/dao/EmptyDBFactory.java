package by.novitsky.simple_user_db.dao;

import java.util.ArrayList;
import java.util.List;

import by.novitsky.simple_user_db.entity.User;

public class EmptyDBFactory implements FactoryDB {

	@Override
	public List<User> getDB() {
		return new ArrayList<User>();
	}
	
	

}
