package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.InventoryPO;

public interface InventoryDataService extends Remote{
	public void update(InventoryPO po)throws RemoteException;
}
