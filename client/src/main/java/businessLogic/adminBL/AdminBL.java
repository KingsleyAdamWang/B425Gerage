package businessLogic.adminBL;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.text.Position;

import po.UserPO;
import dataService.UserDataService;
import client.ClientInitException;
import client.RMIHelper;

public class AdminBL {
	UserDataService UserDS;
	UserPO user;
	List<UserPO> list;
	
	public AdminBL() throws RemoteException{
		try {
			RMIHelper.initUserDataService();
			UserDS = RMIHelper.getUserDataService();
			list = UserDS.getUsers();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean add(String id,String name,String password,String identityID,String institutionID,enumSet.Position work) throws RemoteException{
		List<UserPO> userList=this.list;
		UserPO po=new UserPO(id, name, password, identityID,institutionID, work);
		for(UserPO temp : userList){
			if(temp.getId().equals(po)){
				return false;
			}
		}
		userList.add(po);
		UserDS.add(po);
		return true;
	}
	
	public boolean delete(String id,String name,String password,String identityID,String institutionID,enumSet.Position work) throws RemoteException{
		List<UserPO> userList=this.list;
		UserPO po=new UserPO(id, name, password, identityID,institutionID, work);
		for(UserPO temp : userList){
			if(temp.getId().equals(id)&&temp.getName().equals(name)){
				po=UserDS.find(identityID);
				UserDS.delete(po);
				userList.remove(po);
			}
		}
		return true;
	}
	
	public List update(String message){
		return null;
	}
}
