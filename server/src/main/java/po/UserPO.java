package po;


//用于管理员的账户管理的PO
public class UserPO {
	
	//用户的账户
	private String id;
	//用户的姓名
	private String name;
	//用户的密码
	private String password;
	//用户的员工号
    private String identityID;
    //用户的所属机构号
    private String institutionID;
    //用户的职位
    private String work;
	
    /**
     * 人员的PO
     * @param id
     * @param name
     * @param password
     * @param identityID
     * @param institutionID
     * @param work
     */
   
	public UserPO(String id, String name, String password, String identityID,
			String institutionID, String work) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.identityID = identityID;
		this.institutionID = institutionID;
		this.work = work;
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
	public String getIdentityID() {
		return identityID;
	}
	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}
	public String getInstitutionID() {
		return institutionID;
	}
	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}
	


}
