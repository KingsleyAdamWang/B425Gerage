package data;

import java.rmi.RemoteException;

import dataService.DataFactoryService;
import dataService.LogisticsDataService;
import dataServiceImpl.LogisticsDataServiceImpl;

public class DataFactory implements DataFactoryService {

	//@Override
	public LogisticsDataService getLogisticsData(){
		LogisticsDataService data = null;;
		try {
			data = new LogisticsDataServiceImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
