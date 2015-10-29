package dataService_Stub;

import java.rmi.RemoteException;

import po.EntruckPO;
import dataService.EntruckDataService;

public class EntruckDataStub implements EntruckDataService {


	public void add(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public EntruckPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		EntruckPO po = new EntruckPO();
		return po;
	}

}
