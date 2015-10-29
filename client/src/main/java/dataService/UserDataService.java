package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.UserPO;

public interface UserDataService extends Remote{
	public UserPO find(String id) throws RemoteException;

	public void insert(UserPO po) throws RemoteException;

	public void delete(UserPO po) throws RemoteException;

	public void update(UserPO po) throws RemoteException;

	public void init() throws RemoteException;

	public void finish() throws RemoteException;
}
