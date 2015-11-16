package dataService_Stub;

import java.rmi.RemoteException;

import po.ReceivePO;
import dataService.ReceiveDataService;

public class ReceiveDataStub implements ReceiveDataService {


	public void add(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public ReceivePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ReceivePO po = new ReceivePO(null, id, id, id, null);
		return po;
	}

}
