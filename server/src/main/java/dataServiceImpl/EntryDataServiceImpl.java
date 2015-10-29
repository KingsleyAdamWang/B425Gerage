package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.EntryPO;
import dataService.EntryDataService;

public class EntryDataServiceImpl extends UnicastRemoteObject implements EntryDataService {


	public EntryDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(EntryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(EntryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public EntryPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
