package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.ManagePO;
import po.ManageStrategyPO;
import dataService.ManageDataService;

public class ManageDataServiceImpl extends UnicastRemoteObject implements ManageDataService {


	public  ManageDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add(ManagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void update(ManagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void delete(ManagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public ManagePO check(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public void update(ManageStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public ManageStrategyPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
