package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.InventoryPO;

public interface InventoryDataService extends Remote {

	public void add(InventoryPO po) throws RemoteException;

	public void modify(InventoryPO po) throws RemoteException;
	
	public void delete(String InstitutionID) throws RemoteException;
	
	public List<InventoryPO> getInventoryList()throws RemoteException;

}
