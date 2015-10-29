package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.EntryPO;

public interface EntryDataService extends Remote{
	public void add(EntryPO po)throws RemoteException;
	
	public void delete(EntryPO po)throws RemoteException;
	
	public EntryPO find(String id)throws RemoteException;
}
