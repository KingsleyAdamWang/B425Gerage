package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.TruckPO;
import dataService.TruckDataService;

public class TruckDataServiceImpl extends UnicastRemoteObject implements TruckDataService {


	public  TruckDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(TruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(TruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public TruckPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
