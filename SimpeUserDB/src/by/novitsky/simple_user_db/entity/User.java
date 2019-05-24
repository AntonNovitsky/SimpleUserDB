package by.novitsky.simple_user_db.entity;

import java.io.Serializable;
import java.util.Arrays;

public class User implements Serializable {
	
	private static final long serialVersionUID = 4743827381689968865L;
	
	static int MAX_NUMBER_OF_ROLES;
	static int MAX_NUMBER_OF_PHONES;
	
	static {
		MAX_NUMBER_OF_ROLES = 3;
		MAX_NUMBER_OF_PHONES = 3;
	}
	
	private String name;
	private String secondName;
	private String email;
	private Role [] role;
	private String [] phoneNumber;
	
	private User() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role[] getRole() {
		return role;
	}
	public void setRole(Role[] role) {
		this.role = role;
	}
	public String[] getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String [] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
		@Override
	public String toString() {
		return "User [name=" + name + ", secondName=" + secondName + ", email=" + email + ", role="
				+ Arrays.toString(role) + ", phoneNumber=" + Arrays.toString(phoneNumber) + "]";
	}



		public static class UserBuilder{
			
			User user;
			
			public UserBuilder(){
				user = new User();
			}
			
			public void setName(String name) {
				user.name = name;
			}
			
			public void setSecondName(String secondName) {
				user.secondName = secondName;
			}
			
			public void setEmail(String email) {
				user.email = email;
			}
			
			public void setRole(Role role) {
				user.role = new Role[1];
				user.role[0] = role;
			}
			
			public void setRole(Role[] role) {
				user.role = new Role[role.length];
				for (int i = 0; i < role.length; i++) {
					user.role[i] = role[i];
				}
			}
			
			public void setPhoneNumber(String phoneNumber) {
				user.phoneNumber = new String[1];
				user.phoneNumber[0] = phoneNumber;
			}
			
			public void setPhoneNumber(String[] phoneNumber) {
				user.phoneNumber = new String[phoneNumber.length];
				for (int i = 0; i < phoneNumber.length; i++) {
					user.phoneNumber[i] = phoneNumber[i];
				}
				
			}
			
			public User build() {
				return user;
			}
			
		}
	

}
