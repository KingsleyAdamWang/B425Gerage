package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.TruckPO;

public interface TruckDataService {
	public void add(TruckPO po)throws RemoteException;
	
	public void delete(TruckPO po)throws RemoteException;
	
	public TruckPO find(String id)throws RemoteException;
}
