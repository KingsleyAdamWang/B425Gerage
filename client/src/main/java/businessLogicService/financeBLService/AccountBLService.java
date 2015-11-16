package businessLogicService.financeBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.AccountVO;

/**
 * 
 * 实现银行账户操作的相关业务逻辑的接口
 *
 */
public interface AccountBLService {
	
	public boolean addAccount(String name, String accountID)throws RemoteException ;
	
	public boolean deleteAccount(AccountVO vo)throws RemoteException ;
	
	public List<AccountVO> searchAccount(String key);
	
	public boolean modifyAccount(AccountVO vo, String newName) throws RemoteException ;
	
	public List<AccountVO> getAccounts();
}
