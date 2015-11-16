package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.LogPO;

public interface LogDataService extends Remote{
	public void update(LogPO po)throws RemoteException;
	
	public LogPO check(String id)throws RemoteException;
}
