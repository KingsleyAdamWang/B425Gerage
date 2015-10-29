package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.TransferPO;

public interface TransferDataService extends Remote{
	public void add(TransferPO po)throws RemoteException;
	
	public void delete(TransferPO po)throws RemoteException;
	
	public TransferPO find(String id)throws RemoteException;
}
