package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.IncomePO;

public interface MoneyDataService extends Remote{
	public void addPayment();
	
	public IncomePO check()throws RemoteException;
}
