package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MoneyDataService extends Remote{
	public void addPayment() throws RemoteException;
	
	
}
