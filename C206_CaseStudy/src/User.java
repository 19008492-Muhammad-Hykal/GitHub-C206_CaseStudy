//Bryent (Member 1)

public class User {
	private String name;
	private String role;
	private String email;
	private String password;
	
	public User(String name, String role, String email, String password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		String output = "";
		output += String.format("%s,%s,%s,%s\n",this.getName(),this.getRole(),this.getEmail(),this.getPassword());		
		return output;
		
	}

}
