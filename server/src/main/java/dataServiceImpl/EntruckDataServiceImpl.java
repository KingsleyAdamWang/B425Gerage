package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.EntruckPO;
import dataService.EntruckDataService;

public class EntruckDataServiceImpl extends UnicastRemoteObject implements
		EntruckDataService {


	public EntruckDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public EntruckPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
