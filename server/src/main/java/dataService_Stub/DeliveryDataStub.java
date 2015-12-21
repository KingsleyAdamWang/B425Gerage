package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
import dataService.businessHallDataService.DeliveryDataService;

public class DeliveryDataStub implements DeliveryDataService {

	@Override
	public void add(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approve(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveAll() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DeliveryPO> getList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	

//	public DeliveryPO find(String id) throws RemoteException {
//		// TODO Auto-generated method stub
//		DeliveryPO po = new DeliveryPO();
//		return po;
//	}

}
