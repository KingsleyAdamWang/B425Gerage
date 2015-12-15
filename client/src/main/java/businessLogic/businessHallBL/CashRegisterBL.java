package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.ArrivalPO;
import po.CashRegisterPO;
import po.IncomePO;
import vo.ArrivalVO;
import vo.CashRegisterVO;
import vo.IncomeVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.IncomeDataService;
import enumSet.ReceiptsState;

public class CashRegisterBL {
	private IncomeDataService incomeDS;
	private List<IncomePO> incomeList;
//	private IncomePO incomePO;
	public CashRegisterBL() throws RemoteException {
		try {
			RMIHelper.initIncomeDataService();
			incomeDS = RMIHelper.getIncomeDataService();
			incomeList = incomeDS.getIncomeList();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public String add(IncomeVO vo) throws RemoteException{
		IncomePO po=vo.transToPO();
		
		po.setState(ReceiptsState.unapprove);
		
		incomeList.add(po);
		incomeDS.add(po);
		
		return null;
	}
//不想删掉收款单	
	/*public String delete(IncomeVO vo){
		IncomePO po=vo.transToPO();
		
		incomeList.remove(po);
		incomeDS.;
		return null;
	}*/
	
	public double getFare(){
		double result = 0;
		
		for(IncomePO temp: incomeList){
			result=result+temp.getIncome();
		}
		return result;
	}
	
	public List<IncomePO> getIncomeList(){
		return incomeList;
	}
	
	public List<IncomePO> getIncomePOByPerson(String staffID){
		List<IncomePO> result=incomeList;
		for(IncomePO temp: incomeList){
			if(temp.getKdyID()!=staffID){
				result.remove(temp);
			}
		}
		
		return result;
	}
	
	public List<IncomePO> getIncomeListByDate(Date d){
		List<IncomePO> result=incomeList;
		for(IncomePO temp: result){
			if(!temp.getDate().equals(d)){
				result.remove(temp);
			}
		}
		
		return result;
	}

	public void approve(IncomePO po) throws RemoteException {
		incomeDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		incomeDS.apprivalAll();
	}

	public List<IncomeVO> getUnapproved() {
		List<IncomeVO> result=new ArrayList<IncomeVO>();
		for(IncomePO temp: incomeList){
			if(temp.getState()==ReceiptsState.unapprove){
				result.add(new IncomeVO(temp));
			}
		}
		return result;
	}
	
}
