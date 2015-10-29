package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.TruckPO;

public interface TruckDataService extends Remote{
	public void add(TruckPO po)throws RemoteException;
	
	public void delete(TruckPO po)throws RemoteException;
	
	public TruckPO find(String id)throws RemoteException;
}
