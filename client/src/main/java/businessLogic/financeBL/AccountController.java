package businessLogic.financeBL;
import java.rmi.RemoteException;
import java.util.List;

import vo.AccountVO;
import businessLogicService.financeBLService.AccountBLService;

public class AccountController implements AccountBLService {

	AccountBL accountBL ;
	
	
	public AccountController () throws RemoteException{
		accountBL  = new AccountBL();
	}
	
	
	public boolean addAccount(String name, String accountID)throws RemoteException{
		
		return accountBL.addAccount(name, accountID);
	}
	
	
	public boolean deleteAccount(AccountVO vo) throws RemoteException{
		
		return accountBL.deleteAccount(vo.transToPO());
	}
	
	
	public boolean modifyAccount(AccountVO vo, String newName) throws RemoteException {
		
		return accountBL.modifyAccount(vo, newName);
	}
	


	public List<AccountVO> searchAccount(String key) {
		
		return  accountBL.searchAccount(key);
	}   

	public List<AccountVO> getAccounts() {
	
		return accountBL.getAccounts();
	}
}
