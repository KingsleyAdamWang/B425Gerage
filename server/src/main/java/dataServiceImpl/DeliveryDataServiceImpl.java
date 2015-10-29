package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.DeliveryPO;
import dataService.DeliveryDataService;

public class DeliveryDataServiceImpl extends UnicastRemoteObject implements
		DeliveryDataService {


	public DeliveryDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public DeliveryPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
