package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.UserPO;

public interface AdminDataService extends Remote{
	public void add(UserPO po)throws RemoteException;
	
	public void update(UserPO po)throws RemoteException;
	
	public UserPO find(String id)throws RemoteException;
}
