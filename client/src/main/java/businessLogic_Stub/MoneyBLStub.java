package businessLogic_Stub;

import java.util.Date;
import java.util.List;

import vo.BussinessHallVo.CashRegisterVO;
import vo.FinanceVo.PaymentVO;
import businessLogicService.financeBLService.MoneyBLSerivce;

public class MoneyBLStub implements MoneyBLSerivce {


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

}
