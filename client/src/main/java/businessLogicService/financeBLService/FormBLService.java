package businessLogicService.financeBLService;

import java.util.Date;
import java.util.List;

import vo.FinanceVo.IncomeVO;
import vo.FinanceVo.PaymentVO;

/**
 * 报表操作的业务逻辑的相关接口
 * 
 * @author Kradness
 *
 */
public interface FormBLService {
	public List<IncomeVO> getIncomes();

	public List<PaymentVO> getPayments();

	public List<IncomeVO> getIncomes(Date start, Date end);

	public List<PaymentVO> getPayments(Date start, Date end);

//	public String isValid(String start, String end);

	public void exportCostForm();

	public void exportRunForm(Date start, Date end);
	
	public double getTotalIncome();
	
	public double getTotalPay();

}
