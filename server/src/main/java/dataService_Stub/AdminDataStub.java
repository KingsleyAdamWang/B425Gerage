package dataService_Stub;

import java.rmi.RemoteException;

import po.UserPO;
import dataService.AdminDataService;

public class AdminDataStub implements AdminDataService {


	public void add(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO po = new UserPO(id, "Tom", "12345");
		return po;
	}

}
