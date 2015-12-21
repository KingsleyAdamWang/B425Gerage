package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.SendPO;
import dataService.deliveryDataService.SendDataService;

public class SendDataStub implements SendDataService {

	@Override
	public void add(SendPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SendPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SendPO> getSendList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(SendPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approval(SendPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approvalAll() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	


//	public SendPO find(String id) throws RemoteException {
//		// TODO Auto-generated method stub
//		SendPO po = new SendPO();
//		return po;
//	}

}
