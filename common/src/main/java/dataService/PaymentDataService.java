package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PaymentPO;

public interface PaymentDataService extends Remote{

	public void addPayment(PaymentPO po)throws RemoteException;
	
	}
