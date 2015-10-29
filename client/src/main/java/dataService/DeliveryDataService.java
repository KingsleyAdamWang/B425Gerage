package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.DeliveryPO;

public interface DeliveryDataService extends Remote{
	public void add(DeliveryPO po) throws RemoteException;

	public void delete(DeliveryPO po) throws RemoteException;

	public DeliveryPO find(String id) throws RemoteException;
}
