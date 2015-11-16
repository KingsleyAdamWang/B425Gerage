package businessLogic.loginBL;

import businessLogicService.loginBLService.LoginBLService;

public class LoginController implements LoginBLService {
	LoginBL loginBL;
	public boolean login(String id, String password) {
		return loginBL.login(id, password);
		
	}

}
