package po;

import java.io.Serializable;

import enumSet.ReceiptsState;

public class ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected  ReceiptsState state;
	protected String userID;

	//空的构造方法
	public ReceiptsPO() {
	}

	//构造方法
	public ReceiptsPO(ReceiptsState state, String userID) {
		super();
		this.state = state;
		this.userID = userID;
	}

	public ReceiptsState getState() {
		return state;
	}

	public void setState(ReceiptsState state) {
		this.state = state;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	

	

}
