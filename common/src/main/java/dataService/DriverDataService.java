package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.DriverPO;

public interface DriverDataService extends Remote{
	public void add(DriverPO po)throws RemoteException;
	
	public void delete(DriverPO po)throws RemoteException;
	
	public DriverPO find(String id)throws RemoteException;
}
