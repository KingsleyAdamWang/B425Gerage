package po;

public class UserPO {
	String id;
	String name;
	String password;

	public UserPO(String i, String n, String p) {
		id = i;
		name = n;
		password = p;
	}

	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
