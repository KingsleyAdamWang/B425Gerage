package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import dataService.UserDataService;
import po.UserPO;
import util.CheckUtil;
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
		CheckUtil.checkStaffID(id);
		for(UserPO temp : users){
			if(temp.getIdentityID().equals(id)){
				return "存在相同ID，添加失败";
			}	
		}
		users.add(po);
		userDS.add(po);
		
		
		return null;
	}
	
	public String updateUser(String id,UserVO vo) throws RemoteException{
		UserPO po=vo.transToPO();
		for(UserPO temp : users){
			if(temp.getIdentityID().equals(id)){
				//删除原有PO ，新增PO
				users.remove(temp);
				userDS.delete(temp);
				
				users.add(po);
				userDS.add(po);
				return null;
			}
		}
		return "未找到对应PO";
	}
	
	public String delete(String id) throws RemoteException{
		for(UserPO temp :users){
			if(temp.getIdentityID().equals(id)){
				userDS.delete(temp);
				return null;
			}
		}
		
		return "未找到对应PO";
	}
	
}
