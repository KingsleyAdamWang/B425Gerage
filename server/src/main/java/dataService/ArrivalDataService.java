package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ArrivalPO;

public interface ArrivalDataService extends Remote{
	public void add(ArrivalPO po)throws RemoteException;
	
	public void delete(ArrivalPO po)throws RemoteException;
	
	public ArrivalPO find(String id)throws RemoteException;
}
