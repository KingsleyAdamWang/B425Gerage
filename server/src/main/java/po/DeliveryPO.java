package po;

import java.util.Date;

/**
 * 派件单
 * @author 王栋
 *
 */
public class DeliveryPO {
	/**
	 *时间对象
	 */
	Date d;
	/**
	 * 派件单所派送的货物的快递单号
	 */
	String id;
	/**
	 * 派送员PO
	 */
	UserPO user;
	

	public DeliveryPO(Date d, String id, UserPO user) {
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

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}
}
