package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;

public interface ArrivalDataService extends Remote{
	
	public void add(ArrivalPO po)throws RemoteException;
	
	
	public void delete(ArrivalPO po)throws RemoteException;
	
	public void modify(ArrivalPO po)throws RemoteException;
	
	public void approval(ArrivalPO po)throws RemoteException;
	
	public void approvalAll()throws RemoteException;
	public List<ArrivalPO> getArrivalList()throws RemoteException;
}
