package businessLogic.financeBL;

import java.util.Date;
import java.util.List;

import vo.FinanceVo.IncomeVO;
import vo.FinanceVo.PaymentVO;
import businessLogicService.financeBLService.FormBLService;

public class FormController implements FormBLService {

	private FormBL formBL;

	public FormController() {
		formBL = new FormBL();

	}

	public List<IncomeVO> getIncomes() {
		formBL.getIncomes();
		return formBL.getIncomeList();
	}

	public List<PaymentVO> getPayments() {
		formBL.getPayments();
		return formBL.getPaymentList();
	}

	public void exportCostForm() {

		formBL.exportCostForm();
	}

	public void exportRunForm(Date start, Date end) {
		formBL.exportRunForm(start, end);
	}

	public List<IncomeVO> getIncomes(Date start, Date end) {
		formBL.getIncomes(start, end);
		return formBL.getIncomeList();
	}

	public List<PaymentVO> getPayments(Date start, Date end) {
		formBL.getPayments(start, end);
		return formBL.getPaymentList();
	}

	@Override
	public double getTotalIncome() {

		return formBL.incomeTotal();
	}

	@Override
	public double getTotalPay() {

		return formBL.payTotal();
	}

	// public String isValid(String start, String end) {
	//
	// return formBL.isValid(start, end);
	// }

}
