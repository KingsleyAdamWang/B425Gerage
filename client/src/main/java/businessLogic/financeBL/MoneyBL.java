package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import po.financePO.IncomePO;
import po.financePO.PaymentPO;
import vo.FinanceVo.IncomeVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.financeDataService.IncomeDataService;
import dataService.financeDataService.PaymentDataService;
import enumSet.ReceiptsState;

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
