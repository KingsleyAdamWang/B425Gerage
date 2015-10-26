package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.ShipmentPO;

public interface ShipmentDataService {
	public void add(ShipmentPO po)throws RemoteException;
	
	public void delete(ShipmentPO po)throws RemoteException;
	
	public ShipmentPO find(String id)throws RemoteException;
}
