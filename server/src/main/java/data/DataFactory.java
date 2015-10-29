package data;

import dataService.DataFactoryService;
import dataService.LogisticsDataService;
import dataServiceImpl.LogisticsDataServiceImpl;

public class DataFactory implements DataFactoryService {

	@Override
	public LogisticsDataService getLogisticsData() {
		LogisticsDataService data = new LogisticsDataServiceImpl();
		return data;
	}

}
