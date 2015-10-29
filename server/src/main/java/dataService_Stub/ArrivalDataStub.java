package dataService_Stub;

import java.rmi.RemoteException;

import po.ArrivalPO;
import dataService.ArrivalDataService;

public class ArrivalDataStub implements ArrivalDataService {


	public void add(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public ArrivalPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrivalPO po = new ArrivalPO();
		return po;
	}

}
