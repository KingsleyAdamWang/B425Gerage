package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.ShipmentPO;
import dataService.ShipmentDataService;

public class ShipmentDataStub implements ShipmentDataService {

	@Override
	public void add(ShipmentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ShipmentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(ShipmentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approval(ShipmentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approvalAll() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShipmentPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipmentPO> getList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipmentPO> getListByIns(String institutionID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	

//	public ShipmentPO find(String id) throws RemoteException {
//		// TODO Auto-generated method stub
//		ShipmentPO po = new ShipmentPO();
//		return po;
//	}

}
