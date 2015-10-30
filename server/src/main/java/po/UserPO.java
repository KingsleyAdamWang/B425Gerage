package po;


//用于管理员的账户管理的PO
public class UserPO {
	
	//用户的账户
	private String id;
	//用户的姓名
	private String name;
	//用户的密码
	private String password;
	
	public UserPO(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
	
	
	
	


}
