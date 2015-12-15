package vo;

import po.UserPO;
import enumSet.Position;

public class UserVO {


	

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
     * po转vo的构造方法
     * @param po
     */
    public UserVO(UserPO po){
    	this(po.getName(),po.getPassword(),po.getIdentityID(),po.getInstitutionID(),po.getWork());
    }
    
    
    /**
     * 人员的VO的构造方法
     * @param id
     * @param name
     * @param password
     * @param identityID
     * @param institutionID
     * @param work
     */
	public UserVO(String name, String password, String identityID,
			String institutionID, Position work) {
		super();

		this.name = name;
		this.password = password;
		this.identityID = identityID;
		this.institutionID = institutionID;
		this.work = work;
	}
	
	
  /**
   * 将vo转为po
   * @return
   */
	public UserPO transToPO(){
		return new UserPO(name,password,identityID,institutionID,work);
		
	}

	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getIdentityID() {
		return identityID;
	}
	
	public String getInstitutionID() {
		return institutionID;
	}

	public Position getWork() {
		return work;
	}


	//重写了equals 方法只要就是为了通过比较人员的ID来进行 判断的人员po的存在与否 
	//所以需要排除人员的ID重复的情况 ！！在对应的ＢＬ层需要排除人员的ｉｄ重复
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identityID == null) ? 0 : identityID.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (identityID == null) {
			if (other.identityID != null)
				return false;
		} else if (!identityID.equals(other.identityID))
			return false;
		return true;
	}
	
	
	
}
