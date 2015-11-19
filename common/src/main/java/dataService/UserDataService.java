package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;

public interface UserDataService extends Remote {
	
	public UserPO find(String identityID) throws RemoteException;

	public boolean init() throws RemoteException;

	public void add(UserPO po) throws RemoteException;

	public void delete(UserPO po) throws RemoteException;

//	public void update(UserPO po) throws RemoteException;
	public void modify(UserPO po,String password) throws RemoteException;
	
	public List<UserPO> getUsers() throws RemoteException;


}
