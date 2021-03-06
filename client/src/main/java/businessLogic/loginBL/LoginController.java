package businessLogic.loginBL;

import java.rmi.RemoteException;

import businessLogicService.loginBLService.LoginBLService;
import client.ClientInitException;
import client.RMIHelper;

public class LoginController implements LoginBLService {
	private LoginBL loginBL;

	// private LogDataService logDS;

	public LoginController() throws RemoteException, ClientInitException {
		loginBL = new LoginBL();
		RMIHelper.initLogDataService();
		// logDS=RMIHelper.getLogDataService();
	}

	public boolean login(String id, String password) throws RemoteException {
		// logDS.add(new LogPO(new Date(),id, "登陆"));
		return loginBL.login(id, password);
	}

}
