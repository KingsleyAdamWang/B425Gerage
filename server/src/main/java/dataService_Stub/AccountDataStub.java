package dataService_Stub;

import java.rmi.RemoteException;

import po.AccountPO;
import dataService.AccountDataService;

public class AccountDataStub implements AccountDataService {

	
	public void init() throws RemoteException {
		// TODO Auto-generated method stub

	}


	public void update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public AccountPO check(String id) throws RemoteException {
		AccountPO po = new AccountPO(id, 500);
		return po;
	}

}
