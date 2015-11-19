package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.List;
import client.ClientInitException;
import client.RMIHelper;
import dataService.UserDataService;
import po.UserPO;
import vo.UserVO;

public class StaffBL {
	
	UserDataService userDS;
	List<UserPO> users;
	
	public  StaffBL() throws RemoteException {
		try {
			RMIHelper.initUserDataService();
			userDS = RMIHelper.getUserDataService();
			users = userDS.getUsers();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public UserVO getUser(String id) throws RemoteException{
		
		UserPO po=this.userDS.find(id);
		return new UserVO(po);
	}
	
	public String addUser(String id,UserVO vo) throws RemoteException{
		UserPO po=vo.transToPO();
	
		for(UserPO temp : users){
			if(temp.getIdentityID().equals(id)){
				return "存在相同ID，添加失败";
			}	
		}
		users.add(po);
		userDS.add(po);
		
		
		return null;
	}
	
	public String updateUser(String id,UserVO vo){
		UserPO po=vo.transToPO();
		return null;
	}
	
	public String delete(String id){
		return null;
	}
	
}
