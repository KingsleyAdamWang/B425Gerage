package businessLogic.loginBL;

import java.rmi.RemoteException;
import java.util.List;

import po.adminPO.UserPO;
import presentation.MainFrame;
import vo.AdminVo.UserVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.manageDataService.UserDataService;

public class LoginBL {
	private UserDataService UserDS;
	private UserPO user;
	private List<UserPO> list;

	public LoginBL() throws RemoteException {
		try {
			RMIHelper.initUserDataService();
			UserDS = RMIHelper.getUserDataService();
			list = UserDS.getUsers();
			System.out.println(list.size());
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public boolean login(String id, String password) {

		List<UserPO> list = this.list;
		for (UserPO temp : list) {
			if (temp.getIdentityID().equals(id)) {
				if (temp.getPassword().equals(password)) {// 用户id和密码与输入的都相同
					MainFrame.setUser(new UserVO(temp));
					return true;
				} else {
					return false;// 找到用户id单密码不匹配
				}
			}	
		}
		
		return false;// 未找到用户id
	}
}
