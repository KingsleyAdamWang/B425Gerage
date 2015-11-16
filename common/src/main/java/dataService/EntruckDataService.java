package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.EntruckPO;

public interface EntruckDataService extends Remote{
	public void add(EntruckPO po)throws RemoteException;
	
	public void delete(EntruckPO po)throws RemoteException;
	
	public EntruckPO find(String id)throws RemoteException;
}
