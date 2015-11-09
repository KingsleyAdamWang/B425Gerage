package dataService_Stub;

import java.rmi.RemoteException;

import po.TransferPO;
import dataService.TransferDataService;

public class TransferDataStub implements TransferDataService {


	public void add(TransferPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(TransferPO po) throws RemoteException {
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
