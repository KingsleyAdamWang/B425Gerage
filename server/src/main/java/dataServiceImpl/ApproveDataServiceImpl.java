package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.ApprovePO;
import dataService.ApproveDataService;

public class ApproveDataServiceImpl extends UnicastRemoteObject implements
		ApproveDataService {


	public ApproveDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void update(ApprovePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
