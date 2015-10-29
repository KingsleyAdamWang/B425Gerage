package po;

/*
 * 管理员PO
 * 只存储管理员的账户和密码就好
 */
public class AdminPO {

	private String name_ID;
	private String password;

	public AdminPO(String name_ID, String password) {
		this.name_ID = name_ID;
		this.password = password;

	}

	public AdminPO() {
		this("admin", "admin");
	}

	public String getName_ID() {
		return name_ID;
	}

	public void setName_ID(String name_ID) {
		this.name_ID = name_ID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
