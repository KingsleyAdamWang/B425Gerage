package businessLogic.loginBL;

import presentation.MainFrame;
import vo.UserVO;
import businessLogicService.loginBLService.LoginBLService;

public class LoginController implements LoginBLService {
	LoginBL loginBL;

	public boolean login(String id, String password) {
		MainFrame.setUser(loginBL.getUser(id));
		return loginBL.login(id, password);
		
		
	}
}
