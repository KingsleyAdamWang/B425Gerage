package businessLogic.loginBL;

import po.UserPO;

public class MockUserPO extends UserPO {
	public MockUserPO(String id, String password) {
		this.setId(id);
		this.setPassword(password);
	}
}
