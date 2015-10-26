package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.InventoryPO;

public interface InventoryDataService {
	public void update(InventoryPO po)throws RemoteException;
}
