package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.LogPO;

public interface LogDataService {
	public void update(LogPO po)throws RemoteException;
	
	public LogPO check(String id)throws RemoteException;
}
