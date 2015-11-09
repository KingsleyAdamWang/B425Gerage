package dataService_Stub;

import java.rmi.RemoteException;

import po.ArrivalPO;
import dataService.ArrivalDataService;

public class ArrivalDataStub implements ArrivalDataService {



	@Override
	public boolean add(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ArrivalPO search(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
