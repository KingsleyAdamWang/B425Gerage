package dataService_Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.financePO.AccountPO;
import dataService.financeDataService.AccountDataService;

public class AccountDataStub implements AccountDataService {

	List<AccountPO> tempList ;
	
	public AccountDataStub(){
		init();
	}
	
	private void init(){
		tempList = new ArrayList<AccountPO>();
		tempList.add(new AccountPO("甜甜快递","123456789106556",665699.36));
		tempList.add(new AccountPO("云云快递","546468684646464",4646546.53));
		tempList.add(new AccountPO("天天快递","646464646464648",5454546.26));
		
	}
	@Override
	public boolean modify(AccountPO po) throws RemoteException {
		tempList.set(tempList.indexOf(po), po);
		System.out.println("modify success!");
		return true;
	}

	@Override
	public boolean add(AccountPO po) throws RemoteException {
		tempList.add(po);
		System.out.println("add success!");
		return true;
	}

	@Override
	public boolean delete(AccountPO po) throws RemoteException {
		tempList.remove(po);
		System.out.println("delete success!");
		return true;
	}

	@Override
	public List<AccountPO> search(String key) throws RemoteException {
		List<AccountPO> result = new ArrayList<AccountPO>();
		for(AccountPO po: tempList  )
			if(po.getName().contains(key))
				result.add(po);
		return result;
	}

	@Override
	public List<AccountPO> getAccounts() throws RemoteException {

		return tempList;
	}
}
