package po;

import java.io.Serializable;

import enumSet.Position;




//用于管理员的账户管理的PO
public class UserPO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
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
    private Position work;
	
    /**
     * 人员的PO构造方法
     * @param id
     * @param name
     * @param password
     * @param identityID
     * @param institutionID
     * @param work
     */
   
	public UserPO( String name,String id, String password, String identityID,
			String institutionID, Position work) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.identityID = identityID;
		this.institutionID = institutionID;
		this.work = work;
	}
	
	
	
	public String toString(){
		return this.identityID;
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
	public Position getWork() {
		return work;
	}
	public void setWork(Position work) {
		this.work = work;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identityID == null) ? 0 : identityID.hashCode());
		return result;
	}
	
	
	//重写了equals方法主要是看 人员的姓名人员编号
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPO other = (UserPO) obj;
		if (identityID == null) {
			if (other.identityID != null)
				return false;
		} else if (!identityID.equals(other.identityID))
			return false;
		return true;
	}
	
	
	
	
	


}
