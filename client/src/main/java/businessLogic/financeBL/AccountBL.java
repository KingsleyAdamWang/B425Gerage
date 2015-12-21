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

	public String modifyAccount(AccountVO vo, String newName) throws RemoteException {
         for(AccountPO po: accounts){
        	 if(po.getName().equals(newName))
        		 return "账户名重复！修改失败！";
         }
		
		accounts.get(accounts.indexOf(vo.transToPO())).setName(newName);
		accountDS.modify(vo.transToPO(), newName);
		return null;
	}
	
	public String enter(double fare,String cardNumber){
		AccountPO po=accounts.get(0);
		if(MainFrame.getUser().getWork()==Position.JOB_5||MainFrame.getUser().getWork()==Position.JOB_6){
			double balance=po.getBalance()+fare;
			po.setBalance(balance);
			
		}
		return null;
	}
	
	public String pay(double fare){
		AccountPO po=new AccountPO();
		po.isDefault=false;
		//找到默认账户
		for(AccountPO temp: accounts){
			if(temp.isDefault){
				po=temp;
			}
		}
		if(!po.isDefault){
			return "无默认账户，请先从已添加的账户中设置默认账户";
		}
		
		if(MainFrame.getUser().getWork()==Position.JOB_5||MainFrame.getUser().getWork()==Position.JOB_6){
			double balance=po.getBalance()-fare;
			po.setBalance(balance);
			
		}
		return null;
	}
	
	public String changeDefaultCard(AccountVO newAccount){
		for(AccountPO temp: accounts){
			if(temp.get)
		}
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
