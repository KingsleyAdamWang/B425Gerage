package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.SendPO;

public interface SendDataService extends Remote{
	public void add(SendPO po)throws RemoteException;
	
	public void delete(SendPO po)throws RemoteException;
	
	public SendPO find(String id)throws RemoteException;
	
}
