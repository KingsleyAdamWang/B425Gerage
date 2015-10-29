package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.AccountPO;
import dataService.AccountDataService;

public class AccountDataServiceImpl extends UnicastRemoteObject implements
		AccountDataService {


	public AccountDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public AccountPO check(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
