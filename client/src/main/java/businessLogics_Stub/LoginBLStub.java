package businessLogics_Stub;

import businessLogicsService.LoginBLService;

public class LoginBLStub implements LoginBLService {

	public boolean login(String id, String password) {
		if (id.equals("1") && password.equals("1")) {
			System.out.println("登录成功");
			return true;
		}
		return false;
	}

}
