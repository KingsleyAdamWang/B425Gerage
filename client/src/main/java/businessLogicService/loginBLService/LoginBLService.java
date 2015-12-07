package businessLogicService.loginBLService;

import java.rmi.RemoteException;


public interface LoginBLService {
	public boolean login(String id,String password) throws RemoteException;
}
