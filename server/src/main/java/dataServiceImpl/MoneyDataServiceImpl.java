package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.PaymentPO;
import dataService.PaymentDataService;

public class MoneyDataServiceImpl extends UnicastRemoteObject	 implements PaymentDataService {


	public MoneyDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void addPayment(PaymentPO po) {
		// TODO Auto-generated method stub
		
	}


	
}
