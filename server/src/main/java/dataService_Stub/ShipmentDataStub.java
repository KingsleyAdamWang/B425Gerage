package dataService_Stub;

import java.rmi.RemoteException;

import po.ShipmentPO;
import dataService.ShipmentDataService;

public class ShipmentDataStub implements ShipmentDataService {


	public void add(ShipmentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(ShipmentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public ShipmentPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ShipmentPO po = new ShipmentPO();
		return po;
	}

}
