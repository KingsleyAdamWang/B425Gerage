package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.financePO.IncomePO;
import po.managePO.InstitutionPO;
import vo.DeliverymanVo.SendVO;
import vo.FinanceVo.IncomeVO;
import vo.ManageVo.InstitutionVO;
import businessLogic.deliveryBL.SendBL;
import businessLogic.manageBL.InstitutionBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.financeDataService.IncomeDataService;
import enumSet.InsType;
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
		
		if(po.getIdList().size()==0){
			return "无寄件单，无法建立相关收款单";
		}
		
		incomeList.add(po);
		incomeDS.add(po);
		
		return null;
	}
	
	public String modify(IncomePO income) throws RemoteException{
		int index=-1;
		for(IncomePO temp: incomeList){
			if(temp.equals(income)){
				index=incomeList.indexOf(temp);
			}
		}
		if(index==-1){
			return "未找到对应收款单";
		}
		incomeList.set(index, income);
		incomeDS.modify(income);
		return null;
	} 
	
//	public String find(){
//		
//	}
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
		List<IncomePO> result=new ArrayList<IncomePO>();
		for(IncomePO temp: incomeList){
			if(temp.getKdyID().equals(staffID)){
				result.add(temp);
			}
		}	
		return result;
	}
	
	public List<IncomePO> getIncomeBetweenDate(Date start ,Date end){
		List<IncomePO> result=new ArrayList<IncomePO>();
		for(IncomePO temp: incomeList){
			if(temp.getDate().getTime()>=start.getTime()&&temp.getDate().getTime()<=end.getTime()){
				result.add(temp);
			}
		}
		return result;
	}
	
	public List<IncomePO> getIncomeListByDate(Date d){
		List<IncomePO> result=new ArrayList<IncomePO>();
		for(IncomePO temp: result){
			if(temp.getDate().equals(d)){
				result.add(temp);
			}
		}
		
		return result;
	}
	
	public List<IncomeVO> getIncomeByIns(String institutionID){
		List<IncomeVO> incomeList=new ArrayList<IncomeVO>();
		for(IncomePO temp:this.incomeList){
			if(temp.getInstitutionID().equals(institutionID)){
				incomeList.add(new IncomeVO(temp));
			}
		}
		return null;
	}
	
	public List<InstitutionVO> getBusinessHallList() throws RemoteException{
		InstitutionBL insBL=new InstitutionBL();
		List<InstitutionPO> insList=insBL.getInsList();
		List<InstitutionVO> result=new ArrayList<InstitutionVO>();
		for(InstitutionPO temp: insList){
			if(temp.getType()!=InsType.businessHall){
				insList.remove(temp);
			}
		}
		
		for(InstitutionPO temp: insList){
			result.add(new InstitutionVO(temp));
		}
		return result;
	}
	
	public double getIncomeAmmount(List<IncomeVO> incomeList){
		double ammount=0;
		for(IncomeVO temp: incomeList){
			ammount=ammount+temp.income;
		}
		return ammount;
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
	
	public List<SendVO> getSendByStaffID(Date d,String staffID) throws RemoteException{
		SendBL sendBL=new SendBL();
		return sendBL.getSendByStaff(d,staffID);
	}
	
	public double getSendAmmounts(List<SendVO> sendList){
		double result = 0;
		for(SendVO temp: sendList){
			result=result+temp.getFare();
		}
		
		return result;
	}
}
