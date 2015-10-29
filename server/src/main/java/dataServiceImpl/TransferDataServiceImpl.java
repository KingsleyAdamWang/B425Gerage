package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.TransferPO;
import dataService.TransferDataService;

public class TransferDataServiceImpl extends UnicastRemoteObject implements
		TransferDataService {


	public TransferDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public TransferPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
