package vo;

public class UserVO {
	String id;
	String name;
	String password;

	public UserVO(String i, String n, String p) {
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
