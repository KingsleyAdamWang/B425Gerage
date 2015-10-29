package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.ShipmentPO;
import dataService.ShipmentDataService;

public class ShipmentDataServiceImpl extends UnicastRemoteObject implements
		ShipmentDataService {


	public ShipmentDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(ShipmentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(ShipmentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public ShipmentPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
