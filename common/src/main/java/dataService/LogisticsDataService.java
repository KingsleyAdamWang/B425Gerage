package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.LogisticsPO;

public interface LogisticsDataService extends Remote{
	public LogisticsPO find(String id) throws RemoteException;
	
	public void update(String logistics)throws RemoteException;
	
	public void delete(LogisticsPO po) throws RemoteException;
	
	public void init() throws RemoteException;
}
