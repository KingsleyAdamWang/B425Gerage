package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataFactoryService extends Remote{
	 public LogisticsDataService getLogisticsData() throws RemoteException;
}
