package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.ArrivalPO;
import dataService.ArrivalDataService;

public class ArrivalDataServiceImpl extends UnicastRemoteObject implements
		ArrivalDataService {


	public ArrivalDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public ArrivalPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
