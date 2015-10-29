package vo;

import java.util.Date;

public class DeliveryVO {
	Date d;
	String id;
	UserVO user;

	public DeliveryVO(Date d, String id, UserVO user) {
		super();
		this.d = d;
		this.id = id;
		this.user = user;
	}

	public DeliveryVO() {
		// TODO Auto-generated constructor stub
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
