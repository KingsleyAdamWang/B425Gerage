package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.AccountPO;
import vo.AccountVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.AccountDataService;

public class AccountBL {
	AccountDataService accountDS;
	List<AccountPO> accounts;

	// 构造方法 
	public AccountBL() throws RemoteException {
		try {
			RMIHelper.initAccountDataService();
			accountDS = RMIHelper.getAccountDataService();
			accounts = accountDS.getAccounts();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public boolean addAccount(String name, String accountID)
			throws RemoteException {

		AccountPO po = new AccountPO(name, accountID, 0);

		if (accounts.contains(po))
			return false;

		for (AccountPO temp : accounts) {
			if (temp.getAccountID().equals(accountID))
				return false;
		}
		accounts.add(po);
		accountDS.add(po);

		return true;
	}

	public boolean deleteAccount(AccountPO po) throws RemoteException {
		accounts.remove(po);
		accountDS.delete(po);
		return false;
	}

	// 返回符合关键字key的账户
	public List<AccountVO> searchAccount(String key) {
		List<AccountVO> result = new ArrayList<AccountVO>();

		for (AccountPO temp : accounts) {
			if (temp.getName().contains(key))
				result.add(new AccountVO(temp));
		}
		return result;
	}

	public boolean modifyAccount(AccountVO vo, String newName) throws RemoteException {
//		if(vo.getName().equals(newName))
//			return false ;
		accounts.get(accounts.indexOf(vo.transToPO())).setName(newName);
		accountDS.modify(vo.transToPO(), newName);
		return true;
	}

	public List<AccountVO> getAccounts() {
		List<AccountVO> result = new ArrayList<AccountVO>();

		for (AccountPO temp : accounts) {
			result.add(new AccountVO(temp));
		}
		return result;
	}
}
