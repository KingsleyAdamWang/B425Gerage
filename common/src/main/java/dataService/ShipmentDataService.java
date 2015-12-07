package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ShipmentPO;

public interface ShipmentDataService extends Remote{
	
	public void add(ShipmentPO po)throws RemoteException;
	
	public void delete(ShipmentPO po)throws RemoteException;
	
	public void modify(ShipmentPO po)throws RemoteException;
	
	public void approval(ShipmentPO po)throws RemoteException;
	
	public void approvalAll()throws RemoteException;
	
	public ShipmentPO find(String id)throws RemoteException;
	
	public List<ShipmentPO> getList()throws RemoteException;
	
	public List<ShipmentPO> getListByIns(String institutionID)throws RemoteException;
}
