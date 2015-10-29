package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ReceivePO;

public interface ReceiveDataService extends Remote{
	public void add(ReceivePO po)throws RemoteException;
	
	public void delete(ReceivePO po)throws RemoteException;
	
	public ReceivePO find(String id)throws RemoteException;
}
