package businessLogic.financeBL;

import java.util.Date;
import java.util.List;

import po.CashRegisterPO;
import po.PaymentPO;

public class MoneyBL {
	public double getIncome(){
		return 0;
	}
	
	public double getCashTotal(List<CashRegisterPO> list){
		return 0;
	}
	
	public double getPayTotal(List<PaymentPO> list){
		return 0;
	}
	
	public List<PaymentPO> getPayList(){
		return null;
	}
	
	public List<PaymentPO> getPayList(String start,String end){
		return null;
	}
	
	public List<CashRegisterPO> getCashList(String start,String end){
		return null;
	}
	
	public List<CashRegisterPO> getCashList(String id){
		return null;
	}
	
	public List<CashRegisterPO> getCashList(Date d){
		return null;
	}
	
	public boolean addPayment(PaymentPO po){
		return false;
	}

	public void approveIncome() {
		// TODO Auto-generated method stub
		
	}

	public void approveAllIncome() {
		// TODO Auto-generated method stub
		
	}
}
