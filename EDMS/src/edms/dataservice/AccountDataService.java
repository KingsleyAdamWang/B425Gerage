package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.AccountPO;

public interface AccountDataService {
	public void init()throws RemoteException;
	
	public void update(AccountPO po)throws RemoteException;
	
	public AccountPO check(String id)throws RemoteException;
}
