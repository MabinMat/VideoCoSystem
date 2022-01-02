
public class User {
	private String userName;
	private String name;
	private String password;
	private String email;

	
	public User() {
		userName = null;
		name = null;
		password = null;
		email = null;
	}
	
	public User(String userName, String name, String password, String email) {
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.email = email;
		
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	

}
