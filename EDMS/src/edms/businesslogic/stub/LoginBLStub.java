package edms.businesslogic.stub;

import edms.businesslogicservice.LoginBLService;

public class LoginBLStub implements LoginBLService {

	public boolean login(String username, String password) {
		if(username.equals("1")&&password.equals("1"))
			return true;
		return false;
	}
	
}
