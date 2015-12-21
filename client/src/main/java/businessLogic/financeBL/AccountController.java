package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.logPO.LogPO;
import presentation.MainFrame;
import vo.FinanceVo.AccountVO;
import businessLogicService.financeBLService.AccountBLService;
import client.ClientInitException;
import client.RMIHelper;
import dataService.logDataService.LogDataService;

public class AccountController implements AccountBLService {

	private AccountBL accountBL;
	private LogDataService logDS;
	
	public AccountController() throws RemoteException, ClientInitException {
		accountBL = new AccountBL();
		RMIHelper.initLogDataService();
		logDS=RMIHelper.getLogDataService();
	}

	public String addAccount(String name, String accountID)
			throws RemoteException {
		logDS.add(new LogPO(new Date(),MainFrame.getUser().getIdentityID(),"新增账户"));
		return accountBL.addAccount(name, accountID);
	}

	public boolean deleteAccount(AccountVO vo) throws RemoteException {
		logDS.add(new LogPO(new Date(),MainFrame.getUser().getIdentityID(),"删除账户"));
		return accountBL.deleteAccount(vo.transToPO());
	}

	public String modifyAccount(AccountVO vo, String newName)
			throws RemoteException {
		logDS.add(new LogPO(new Date(),MainFrame.getUser().getIdentityID(),"修改账户"));
		return accountBL.modifyAccount(vo, newName);
	}

	public List<AccountVO> searchAccount(String key) throws RemoteException {
		logDS.add(new LogPO(new Date(),MainFrame.getUser().getIdentityID(),"查询账户"));
		return accountBL.searchAccount(key);
	}

	public List<AccountVO> getAccounts() {

		return accountBL.getAccounts();
	}
}
