package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.financePO.AccountPO;
import dataService.financeDataService.AccountDataService;

public class AccountDataStub implements AccountDataService {

	
	


	public void update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}


	public AccountPO check(String id) throws RemoteException {
		AccountPO po = new AccountPO(id,"535655", 500);
		return po;
	}


	public boolean init() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean modify(AccountPO po, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean add(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public List<AccountPO> search(String key) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public List<AccountPO> getAccounts() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
