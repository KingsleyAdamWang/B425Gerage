package dataService_Stub;

import java.rmi.RemoteException;

import po.SendPO;
import dataService.SendDataService;

public class SendDataStub implements SendDataService {


	public void add(SendPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void delete(SendPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	@Override
	public SendPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


//	public SendPO find(String id) throws RemoteException {
//		// TODO Auto-generated method stub
//		SendPO po = new SendPO();
//		return po;
//	}

}
