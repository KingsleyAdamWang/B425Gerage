package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.IncomePO;
import dataService.MoneyDataService;

public class MoneyDataServiceImpl extends UnicastRemoteObject	 implements MoneyDataService {


	public MoneyDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void addPayment() {
		// TODO Auto-generated method stub
		
	}


	public IncomePO check() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
