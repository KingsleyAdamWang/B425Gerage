package dataService_Stub;

import java.rmi.RemoteException;

import po.UserPO;
import dataService.UserDataService;

public class UserDataStub implements UserDataService {


	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO po = new UserPO(id, "Tom", "12345");
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


	public void init() throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void finish() throws RemoteException {
		// TODO Auto-generated method stub

	}

}
