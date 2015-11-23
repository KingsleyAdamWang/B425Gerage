package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.LogPO;

public interface LogDataService extends Remote {

	public  void add(LogPO po) throws RemoteException;

	
	public void clear() throws RemoteException;
	
	public List<LogPO> getLogList()throws RemoteException;
}
