package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.List;

import vo.FinanceVo.AccountVO;
import businessLogicService.financeBLService.AccountBLService;

public class InitBillController implements AccountBLService {
	public void initBill(String name){
		
	}

	public String addAccount(String name, String accountID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteAccount(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<AccountVO> searchAccount(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String modifyAccount(AccountVO vo, String newName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AccountVO> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}	
}
