package businessLogic.loginBL;

import java.rmi.RemoteException;
import java.util.List;
import client.ClientInitException;
import client.RMIHelper;
import po.UserPO;
import dataService.UserDataService;

public class LoginBL {
	UserDataService UserDS;
	UserPO user;
	List<UserPO> list;
	
	public LoginBL() throws RemoteException{
		try {
			RMIHelper.initUserDataService();
			UserDS = RMIHelper.getUserDataService();
			list = UserDS.getUsers();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public boolean login(String id ,String password){
		List<UserPO> list=this.list;
		for(UserPO temp : list){
			if(temp.getIdentityID().equals(id)){
				if(temp.getPassword().equals(password))//用户id和密码与输入的都相同
				return true;
			}else{
				return false;//找到用户id单密码不匹配
			}
		}
		return false;//未找到用户id
	}
}
