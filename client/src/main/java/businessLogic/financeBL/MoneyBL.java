package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import po.businessPO.CashRegisterPO;
import po.financePO.IncomePO;
import po.financePO.PaymentPO;
import util.DateUtil;
import dataService.financeDataService.IncomeDataService;
import dataService.financeDataService.PaymentDataService;

public class MoneyBL {
//	private CashRegisterBL crBL;
//	private PaymentBL paymentBL;
	private IncomeDataService incomeDS;
	private List<IncomePO> incomeList;
	private PaymentDataService paymentDS;
	private List<PaymentPO> paymentList;
	
	public MoneyBL() throws RemoteException{
		try {
			RMIHelper.initIncomeDataService();
			incomeDS = RMIHelper.getIncomeDataService();
			incomeList = incomeDS.getIncomeList();

			RMIHelper.initPaymentDataService();
			paymentDS = RMIHelper.getPaymentDataService();
			paymentList = paymentDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public double getIncomeBetween(Date start,Date end){
		double result=0;
//		start	=DateUtil.stringToDate(DateUtil.dateToString(start));
//		end		=DateUtil.stringToDate(DateUtil.dateToString(end));
		for(IncomePO temp : incomeList){
			if(temp.getDate().getTime()>=start.getTime()&&temp.getDate().getTime()<=end.getTime()){
				result=result+temp.getIncome();
			}
		}
		
		return result;
	}
	
	public double getPaymentBetween(Date start,Date end){
		double result=0;
//		start	=DateUtil.stringToDate(DateUtil.dateToString(start));
//		end		=DateUtil.stringToDate(DateUtil.dateToString(end));
		for(PaymentPO temp : paymentList){
			if(temp.getD().getTime()>=start.getTime()&&temp.getD().getTime()<=end.getTime()){
				result=result+temp.getAmmounts();
			}
		}
		
		return result;
	}
	
//	public getPaymentByDate(){
//		
//	}
	

	
	//后面都没用
	
//	public double getCashTotal(List<CashRegisterPO> list){
//		return 0;
//	}
//	
//	public double getPayTotal(List<PaymentPO> list){
//		return 0;
//	}
//	
//	public List<PaymentPO> getPayList(){
//		return null;
//	}
//	
//	public List<PaymentPO> getPayList(String start,String end){
//		return null;
//	}
//	
//	public List<CashRegisterPO> getCashList(String start,String end){
//		return null;
//	}
//	
//	public List<CashRegisterPO> getCashList(String id){
//		return null;
//	}
//	
//	public List<CashRegisterPO> getCashList(Date d){
//		return null;
//	}
//	
//	public boolean addPayment(PaymentPO po){
//		return false;
//	}
//
//	public void approveIncome() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void approveAllIncome() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public List<IncomePO> getUnapproved() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
