package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.EntruckPO;

public interface EntruckDataService {
	public void add(EntruckPO po)throws RemoteException;
	
	public void delete(EntruckPO po)throws RemoteException;
	
	public EntruckPO find(String id)throws RemoteException;
}
