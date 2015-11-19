package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;
import dataService.UserDataService;

public class UserDataStub implements UserDataService {


	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO po = new UserPO(id,  "12345", id, id, null);
		return po;
	}


	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}





	public void finish() throws RemoteException {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean init() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void add(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}




	@Override
	public List<UserPO> getUsers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void modify(UserPO po, String password) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
