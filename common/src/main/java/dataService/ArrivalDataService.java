package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ArrivalPO;

public interface ArrivalDataService extends Remote{
	
	public boolean add(ArrivalPO po)throws RemoteException;
	
	
	public boolean delete(ArrivalPO po)throws RemoteException;
	
	
	public ArrivalPO search(String id)throws RemoteException;
	
	
}
