package by.novitsky.simple_user_db.dao;

import java.util.List;

import by.novitsky.simple_user_db.entity.User;

public class LoadDBFactory implements FactoryDB {

	@Override
	public List<User> getDB() {
		return AccessUserDB.loadDB();
	}

}
