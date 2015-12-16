package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessLogic.businessHallBL.CashRegisterBL;
import po.IncomePO;
import po.LogPO;
import po.PaymentPO;
import presentation.MainFrame;
import util.DateUtil;
import vo.IncomeVO;
import vo.PaymentVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.LogDataService;


public class FormBL {
	
	private List<IncomePO> incomes;
	private List<PaymentPO> payments;
	private LogDataService logDS;
	
	public FormBL(){
		try {
			RMIHelper.initLogDataService();
			logDS = RMIHelper.getLogDataService();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出选定日期区间的经营情况表
	 * @param start开始时间
	 * @param end截止时间
	 * @return  成功与否 
	 */
	public String  exportRunForm(Date start, Date end){
		
		
		
		try {
		logDS.add(new LogPO(new Date(),
				MainFrame.getUser().getIdentityID(), "导出"
						+ DateUtil.dateToString(start) + "至"
						+ DateUtil.dateToString(end) + "经营情况表"));
	} catch (RemoteException e) {
		e.printStackTrace();
	}
		return null;
	}
	
	/**
	 * 导出截至到当先日期的成本收益表
	 * @return 成功显示与否
	 */
	public String exportCostForm(){
		
		try {
			logDS.add(new LogPO(new Date(),
					MainFrame.getUser().getIdentityID(), "导出成本收益表"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void getIncomes(){
	try {
		CashRegisterBL cashBL= new CashRegisterBL();
		incomes = cashBL.getIncomeList();
	} catch (RemoteException e) {
		e.printStackTrace();
	}
	
	
	}

	public void getPayments(){
		try {
			PaymentBL payBL = new PaymentBL();
			payments = payBL.getPaymentList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	public void  getIncomes(Date start, Date end){
		try {
		CashRegisterBL cashBL  = new CashRegisterBL();
		incomes = cashBL.getIncomeBetweemDate(start, end);

		} catch (RemoteException e) {

			e.printStackTrace();
		}
		
	}

	public void getPayments(Date start, Date end){
		PaymentBL payBL;
		try {
			payBL = new PaymentBL();
			payments = payBL.betweenDate(start, end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	
	public String  isValid(String start, String end){
		Date begin,ends;
		try{
			begin = DateUtil.stringToDate(start);
			ends = DateUtil.stringToDate(end);
		}
		catch(Exception e){
			e.printStackTrace();
			return "输入的时间格式不正确！";
		}
		if(begin.getTime()>ends.getTime()){
			return "起止时间的输入不符合时逻辑！";
		}
		return null;
		
	}
	
	public List<IncomeVO> getIncomeList(){
		List<IncomeVO> result = new ArrayList<IncomeVO>();
		for(IncomePO po : incomes){
			result.add(new IncomeVO(po));
		}
		return result;
	}
	
	public List<PaymentVO> getPaymentList(){
		List<PaymentVO> result = new ArrayList<PaymentVO>();
		for(PaymentPO po : payments){
			result.add(new PaymentVO(po));
		}
		return result;
	}
}
