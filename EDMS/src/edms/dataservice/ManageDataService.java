package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.ManagePO;
import edms.po.ManageStrategyPO;

public interface ManageDataService {
	public void add(ManagePO po)throws RemoteException;
	
	public void update(ManagePO po)throws RemoteException;
	
	public void delete(ManagePO po)throws RemoteException;
	
	public ManagePO check(String id)throws RemoteException;
	
	public void update(ManageStrategyPO po)throws RemoteException;
	
	public ManageStrategyPO find(String id)throws RemoteException;
}
