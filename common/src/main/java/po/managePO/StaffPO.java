package po.managePO;

import java.io.Serializable;

public class StaffPO implements Serializable{
	private static final long serialVersionUID = 1L;


	//工作人员的名字
	private String name;
	
	//该工作人员的编号
	
	private String ID;
	
	//工作人员所属的机构编号  财务人员的编号为000和001 总经理的是111  001属于财务人员的最高权限 000属于较低的财务人员权限
	private String institutionID;
	
	//工作人员的职位
	private String work;
	
	//工作人员的登录客户端的账号
	private String account;
	
	//密码
	private String password;
	

	public StaffPO(String name, String iD, String institutionID, String work) {
		super();
		this.name = name;
		ID = iD;
		this.institutionID = institutionID;
		this.work = work;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
	
	


}
