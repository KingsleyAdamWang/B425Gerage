package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.AccountPO;

public interface AccountDataService extends Remote{
	
	
	public boolean init()throws RemoteException;
	
//	public boolean update()throws RemoteException;
	
	public boolean modify(AccountPO po,String name)throws RemoteException;
	
	public boolean add(AccountPO po)throws RemoteException;
	
	public boolean delete(AccountPO po)throws RemoteException;
	
	public List<AccountPO> search(String key)throws RemoteException;
	
	public List<AccountPO> getAccounts() throws RemoteException;
	
//	public List<AccountPO> search(String key);
	
//	public AccountPO check(String id)throws RemoteException;
}
