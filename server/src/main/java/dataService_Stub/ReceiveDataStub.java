package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.deliveryPO.ReceivePO;
import dataService.deliveryDataService.ReceiveDataService;

public class ReceiveDataStub implements ReceiveDataService {

	@Override
	public void add(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReceivePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approve(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveAll() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReceivePO> getList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}




//	public ReceivePO find(String id) throws RemoteException {
//		// TODO Auto-generated method stub
//		ReceivePO po = new ReceivePO(null, id, id, id, null);
//		return po;
//	}

}
