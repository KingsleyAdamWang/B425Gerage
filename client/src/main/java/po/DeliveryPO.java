package po;

import java.util.Date;

import vo.UserVO;

public class DeliveryPO {
	Date d;
	String id;
	UserVO user;
	
	public DeliveryPO(){
		
	}

	public DeliveryPO(Date d, String id, UserVO user) {
		super();
		this.d = d;
		this.id = id;
		this.user = user;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}
}
