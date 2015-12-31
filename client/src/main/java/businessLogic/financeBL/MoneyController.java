package businessLogic.financeBL;

import java.util.Date;
import java.util.List;

import vo.BussinessHallVo.CashRegisterVO;
import vo.FinanceVo.PaymentVO;
import businessLogicService.financeBLService.MoneyBLSerivce;

public class MoneyController implements MoneyBLSerivce {

	public List<CashRegisterVO> checkCash(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CashRegisterVO> checkCash(String institutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean submitPay(PaymentVO payment) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<PaymentVO> checkPay() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CashRegisterVO> getCashList() {
		return null;
	}

	public List<CashRegisterVO> getCashList(String id) {
		return null;
	}

	public List<CashRegisterVO> getCashList(Date date) {
		return null;
	}

	public List<CashRegisterVO> getCashList(String start, String end) {
		return null;
	}

	public List<PaymentVO> getPayList(String start, String end) {
		return null;
	}

	public List<PaymentVO> getPayList() {
		return null;
	}

	public Boolean addPayment(PaymentVO pVO) {
		return false;
	}

	public double getCashTotal(List<CashRegisterVO> list) {
		return 0;
	}

	public double getIncome() {
		return 0;
	}

	public double getPayTotal(List<PaymentVO> list) {
		return 0;
	}

}
