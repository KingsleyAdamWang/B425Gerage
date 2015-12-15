package vo;

import enumSet.ReceiptsState;


public class ReceiptsVO {
	
	public  ReceiptsState state;
	
	public  String userID;
	
	/**
	 * 构造方法
	 * @param state
	 * @param userID
	 */
	public ReceiptsVO(ReceiptsState state, String userID) {
		super();
		this.state = state;
		this.userID = userID;
	}
	
//	//各种getSet方法
//	public ReceiptsState getState() {
//		return state;
//	}
//	public void setState(ReceiptsState state) {
//		this.state = state;
//	}
//	public String getUserID() {
//		return userID;
//	}

	
	
}
