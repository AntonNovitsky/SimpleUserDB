package by.novitsky.simple_user_db.entity;

public enum Role {
	
	ROLE_1 (1, "Admin"),
	ROLE_2 (2, "Manager"),
	ROLE_3 (3, "Tester");
	
	private int code;
	private String nameOfRole;
	
	Role(int code, String nameOfRole){
		this.code = code;
		this.nameOfRole = nameOfRole;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getNameOfRole() {
		return nameOfRole;
	}
	
	public static Role findByNameOfRole(String input) {
		Role[] roles = Role.values();
		for (Role role : roles) {
			if (role.getNameOfRole().equals(input)) {
				return role;
			}
		}
		return null;
	}

}
