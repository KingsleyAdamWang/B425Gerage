package edms.data;

import edms.dataservice.DataFactoryService;
import edms.dataservice.LogisticsDataService;
import edms.dataservice.impl.LogisticsDataServiceSerializableFileImpl;

public class DataFactory implements DataFactoryService {

	@Override
	public LogisticsDataService getLogisticsData() {
		LogisticsDataService data = new LogisticsDataServiceSerializableFileImpl();
		return data;
	}

}
