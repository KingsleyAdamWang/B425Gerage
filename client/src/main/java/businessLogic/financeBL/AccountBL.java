package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.financePO.AccountPO;
import po.financePO.PaymentPO;
import presentation.MainFrame;
import vo.FinanceVo.AccountVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.financeDataService.AccountDataService;
import enumSet.Position;

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

	public String addAccount(String name, String accountID)
			throws RemoteException {
		AccountPO po = new AccountPO(name, accountID, 0);

		if (accounts.contains(po))
			return "账户名已存在！添加失败！";

		for (AccountPO temp : accounts) {
			if (temp.getAccountID().equals(accountID))
				return "卡号已被绑定！添加失败！";
		}
		accounts.add(po);
		accountDS.add(po);

		return null;
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

	public String modifyAccount(AccountVO vo) throws RemoteException {
        AccountPO newAccount=vo.transToPO();
        boolean exist=false;
        for(AccountPO temp: accounts){
        	if(temp.getAccountID().equals(vo.getAccountID()))
        		exist=true;
        		break;
        }
        if(exist==false)
        	return "未找到卡号对应账户，不予修改";
        
		for(AccountPO temp: accounts){
        	 if(temp.getName().equals(vo.getName()))
        		 return "账户名重复！修改失败！";
        	 
        	 if(vo.getAccountID().equals(temp.getAccountID())){
        		 accountDS.modify(newAccount);
     			return null;
        	 }
         }
		
		return "未找到对应账户，不予修改";	
	}
	
	
	public String enter(double fare) throws RemoteException{
		AccountPO po=accounts.get(0);
		if(MainFrame.getUser().getWork()==Position.JOB_2||MainFrame.getUser().getWork()==Position.JOB_5||MainFrame.getUser().getWork()==Position.JOB_6){
			double balance=po.getBalance()+fare;
			po.setBalance(balance);
			accountDS.modify(po);
			accounts=accountDS.getAccounts();
			return null;
		}
		return "无权限做此操作";
	}
	
	public String pay(double fare) throws RemoteException{
		AccountPO po=accounts.get(0);	
		if(MainFrame.getUser().getWork()==Position.JOB_2||MainFrame.getUser().getWork()==Position.JOB_5||MainFrame.getUser().getWork()==Position.JOB_6){
			double balance=po.getBalance()-fare;
			if(balance<0){
				return "余额不足，无法支出";
			}
			po.setBalance(balance);
			accountDS.modify(po);
			accounts=accountDS.getAccounts();
			return null;
		}
		return "无权限做此操作";
	}
	
	public String changeDefaultCard(AccountVO newAccount) throws RemoteException{
		AccountPO po=newAccount.transToPO();
		
		accountDS.delete(po);
		accountDS.add(po);
		accounts=accountDS.getAccounts();
		
		return null;
	}
	
	public List<AccountVO> getAccounts() {
		List<AccountVO> result = new ArrayList<AccountVO>();

		for (AccountPO temp : accounts) {
			result.add(new AccountVO(temp));
		}
		return result;
	}
}
