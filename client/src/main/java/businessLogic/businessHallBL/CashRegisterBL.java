package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.List;

import po.CashRegisterPO;
import po.IncomePO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.IncomeDataService;

public class CashRegisterBL {
	private IncomeDataService incomeDS;
	private List<IncomePO> incomeList;

	public CashRegisterBL() throws RemoteException {
		try {
			RMIHelper.initIncomeDataService();
			incomeDS = RMIHelper.getIncomeDataService();
			incomeList = incomeDS.getIncomeList();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public String add(){
		return null;
	}
	
	public String delete(){
		return null;
	}
	
	public double getFare(){
		return 0;
	}
	
	public List<IncomePO> getIncomeList(){
		return incomeList;
	}
	
	public List<IncomePO> getIncomeListByDate(){
		
		
		return null;
	}
	
}
