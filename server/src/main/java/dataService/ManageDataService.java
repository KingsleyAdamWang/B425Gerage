package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ManagePO;
import po.ManageStrategyPO;

public interface ManageDataService extends Remote{
	public void add(ManagePO po)throws RemoteException;
	
	public void update(ManagePO po)throws RemoteException;
	
	public void delete(ManagePO po)throws RemoteException;
	
	public ManagePO check(String id)throws RemoteException;
	
	public void update(ManageStrategyPO po)throws RemoteException;
	
	public ManageStrategyPO find(String id)throws RemoteException;
}
