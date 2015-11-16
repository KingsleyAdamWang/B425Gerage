package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.LogisticsPO;
import dataService.LogisticsDataService;

public class LogisticsDataStub implements LogisticsDataService {



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
	public void add(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean modify(String id, String message) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public List<LogisticsPO> getLogisticsList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
