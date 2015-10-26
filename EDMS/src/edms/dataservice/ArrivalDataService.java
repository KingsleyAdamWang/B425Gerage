package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.ArrivalPO;

public interface ArrivalDataService {
	public void add(ArrivalPO po)throws RemoteException;
	
	public void delete(ArrivalPO po)throws RemoteException;
	
	public ArrivalPO find(String id)throws RemoteException;
}
