package businessLogic_Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import vo.AccountVO;
import businessLogicService.financeBLService.AccountBLService;

public class AccountBLStub implements AccountBLService {

	public void add(String name, double balance) {
		// TODO Auto-generated method stub

	}


	public void modify(AccountVO vo, String name) {
		// TODO Auto-generated method stub

	}


	public void delete(AccountVO vo) {
		// TODO Auto-generated method stub

	}


	public List<AccountVO> check(String key) {
		// TODO Auto-generated method stub
		List<AccountVO> list = new ArrayList<AccountVO>();
		return list;
	}


	@Override
	public String addAccount(String name, String accountID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteAccount(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<AccountVO> searchAccount(String key) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String modifyAccount(AccountVO vo, String newName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<AccountVO> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

}
