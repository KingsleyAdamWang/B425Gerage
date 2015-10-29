package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.SendPO;
import dataService.SendDataService;

public class SendDataServiceImpl extends UnicastRemoteObject implements SendDataService {


	protected SendDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(SendPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(SendPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public SendPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
