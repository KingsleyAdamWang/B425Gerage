package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.EntryPO;

public interface EntryDataService {
	public void add(EntryPO po)throws RemoteException;
	
	public void delete(EntryPO po)throws RemoteException;
	
	public EntryPO find(String id)throws RemoteException;
}
