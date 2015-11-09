package po;

import enumSet.ReceiptsState;

public class ReceiptsPO {
	
	protected ReceiptsState state;
	protected UserPO user;
	
	
	
	
	
	public ReceiptsPO(ReceiptsState state, UserPO user) {
		super();
		this.state = state;
		this.user = user;
	}
	
	
	public ReceiptsState getState() {
		return state;
	}
	public void setState(ReceiptsState state) {
		this.state = state;
	}
	public UserPO getUser() {
		return user;
	}
	public void setUser(UserPO user) {
		this.user = user;
	}
	
	

}
