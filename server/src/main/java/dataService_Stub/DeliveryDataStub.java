package dataService_Stub;

import java.rmi.RemoteException;

import po.DeliveryPO;
import dataService.DeliveryDataService;

public class DeliveryDataStub implements DeliveryDataService {


	public void add(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public DeliveryPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		DeliveryPO po = new DeliveryPO();
		return po;
	}

}
