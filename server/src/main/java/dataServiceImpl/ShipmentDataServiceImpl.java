package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.ShipmentPO;
import dataService.ShipmentDataService;

public class ShipmentDataServiceImpl extends UnicastRemoteObject implements
		ShipmentDataService {


	public ShipmentDataServiceImpl() throws RemoteException {
		super();
	
	}
	
	private void init(){
		
	}

	private void update(){
		
	}

	public void add(ShipmentPO po) throws RemoteException {
	
		
	}


	public void delete(ShipmentPO po) throws RemoteException {
	
		
	}


	public ShipmentPO find(String id) throws RemoteException {
	
		return null;
	}

}
