package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;

public interface DeliveryDataService extends Remote{
	
	public void add(DeliveryPO po) throws RemoteException;

	public void delete(DeliveryPO po) throws RemoteException;
	
	public void modify(DeliveryPO po) throws RemoteException;
	
    public void approve(DeliveryPO po)throws RemoteException;
    
    public void approveAll()throws RemoteException;
    
    public List<DeliveryPO> getList()throws RemoteException;
    

	public DeliveryPO find(String id) throws RemoteException;
}
