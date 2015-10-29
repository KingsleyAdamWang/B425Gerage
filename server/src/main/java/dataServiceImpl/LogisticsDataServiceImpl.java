package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.LogisticsPO;
import dataService.LogisticsDataService;

public class LogisticsDataServiceImpl extends UnicastRemoteObject implements
		LogisticsDataService {


	public LogisticsDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public LogisticsPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public void update(String logistics) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
