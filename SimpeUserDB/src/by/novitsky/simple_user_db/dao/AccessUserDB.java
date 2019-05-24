package by.novitsky.simple_user_db.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import by.novitsky.simple_user_db.entity.User;

public class AccessUserDB {
	
	private static String DB_PATH = "C:\\user_db";
	private static String IO_ERROR_NOT_FOUND = "File not found, please check configurations";
	private static String IO_ERROR = "I/O error occured";
	private static String CLASS_NOT_FOUND_ERROR = "Class not found";
	
	@SuppressWarnings("unchecked")
	public static List<User> loadDB(){
		
		List<User> result = new ArrayList<User>();
		
		try {
			FileInputStream fileInputStream = new FileInputStream(DB_PATH);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			result = (List<User>) objectInputStream.readObject();
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(IO_ERROR_NOT_FOUND);
			System.exit(0);
		} catch (IOException e) {
			System.out.println(IO_ERROR);
			e.printStackTrace();
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.out.println(CLASS_NOT_FOUND_ERROR);
			System.exit(0);
		}
		return result;
	}
	
	public static void saveDB(List<User> inputUserList){
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(DB_PATH);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(inputUserList);
		    objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(IO_ERROR_NOT_FOUND);
			System.exit(0);
		} catch (IOException e) {
			System.out.println(IO_ERROR);
			System.exit(0);
		}
	    
	}

}
