package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.intermidatePO.TransferPO;
import dataService.intermidateDataService.TransferDataService;

public class TransferDataStub implements TransferDataService {

	@Override
	public void add(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TransferPO> getList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approve(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveAll() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransferPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}




//	public TransferPO find(String id) throws RemoteException {
//		// TODO Auto-generated method stub
//		TransferPO po = new TransferPO();
//		return po;
//	}

}
