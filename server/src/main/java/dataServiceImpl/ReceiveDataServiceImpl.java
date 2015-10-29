package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.ReceivePO;
import dataService.ReceiveDataService;

public class ReceiveDataServiceImpl extends UnicastRemoteObject implements
		ReceiveDataService {


	public ReceiveDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public ReceivePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
