package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.ConditionPO;
import po.ExportPO;
import dataService.FormDataService;

public class FormDataServiceImpl extends UnicastRemoteObject implements FormDataService {


	public FormDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConditionPO checkCondition() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public void export(ExportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
