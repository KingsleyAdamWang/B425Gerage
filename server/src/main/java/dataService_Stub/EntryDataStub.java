package dataService_Stub;

import java.rmi.RemoteException;

import po.EntryPO;
import dataService.EntryDataService;

public class EntryDataStub implements EntryDataService {


	public void add(EntryPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(EntryPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	@Override
	public EntryPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


//	public EntryPO find(String id) throws RemoteException {
//		EntryPO po = new EntryPO();
//		return po;
//	}

}
