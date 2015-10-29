package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.AccountPO;

public interface AccountDataService extends Remote{
	public void init()throws RemoteException;
	
	public void update(AccountPO po)throws RemoteException;
	
	public AccountPO check(String id)throws RemoteException;
}
