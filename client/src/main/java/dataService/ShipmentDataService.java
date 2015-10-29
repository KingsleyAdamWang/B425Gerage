package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ShipmentPO;

public interface ShipmentDataService extends Remote{
	public void add(ShipmentPO po)throws RemoteException;
	
	public void delete(ShipmentPO po)throws RemoteException;
	
	public ShipmentPO find(String id)throws RemoteException;
}
