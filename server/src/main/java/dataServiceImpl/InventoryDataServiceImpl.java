package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.InventoryPO;
import dataService.InventoryDataService;

public class InventoryDataServiceImpl extends UnicastRemoteObject implements
		InventoryDataService {


	public InventoryDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void update(InventoryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
