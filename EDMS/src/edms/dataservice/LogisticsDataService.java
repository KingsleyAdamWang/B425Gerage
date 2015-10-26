package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.LogisticsPO;

public interface LogisticsDataService {
	public LogisticsPO find(String id) throws RemoteException;
	
	public void update(String logistics)throws RemoteException;
	
	public void delete(LogisticsPO po) throws RemoteException;
	
	public void init() throws RemoteException;
}
