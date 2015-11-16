package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.LogisticsPO;

public interface LogisticsDataService extends Remote {

//	public void update(String logistics) throws RemoteException;

	public void add(LogisticsPO po) throws RemoteException;

	public boolean modify(String id, String message) throws RemoteException;

	public List<LogisticsPO> getLogisticsList() throws RemoteException;

}
