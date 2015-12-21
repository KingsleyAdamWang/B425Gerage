package dataService_Stub;

import java.rmi.RemoteException;
import java.sql.Driver;

import dataService.businessHallDataService.DriverDataService;
import po.businessPO.DriverPO;

public class DriverDataStub implements DriverDataService{

	@Override
	public void add(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DriverPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
		
}
