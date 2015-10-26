package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.UserPO;

public interface UserDataService {
	public UserPO find(long id) throws RemoteException;
	
	public void insert(UserPO po) throws RemoteException;
	
	public void delete(UserPO po)throws RemoteException;
	
	public void update(UserPO po)throws RemoteException;
	
	public void init()throws RemoteException;
	
	public void finish() throws RemoteException;
}
