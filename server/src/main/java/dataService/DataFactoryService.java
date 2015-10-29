package dataService;

import java.rmi.Remote;

public interface DataFactoryService extends Remote{
	 public LogisticsDataService getLogisticsData();
}
