package dataService_Stub;

import java.rmi.RemoteException;

import po.LogisticsPO;
import dataService.LogisticsDataService;

public class LogisticsDataStub implements LogisticsDataService {

//
//	public LogisticsPO find(String id) throws RemoteException {
//		LogisticsPO po = new LogisticsPO();
//		return po;
//	}
//

	public void update(String logistics) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void init() throws RemoteException {
		// TODO Auto-generated method stub

	}


	@Override
	public LogisticsPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
