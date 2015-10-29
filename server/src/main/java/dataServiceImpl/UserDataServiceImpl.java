package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.UserPO;
import dataService.UserDataService;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService {


	public  UserDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
