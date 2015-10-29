package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.LogPO;
import dataService.LogDataService;

public class LogDataServiceImpl extends UnicastRemoteObject implements LogDataService {


	public LogDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void update(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public LogPO check(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
