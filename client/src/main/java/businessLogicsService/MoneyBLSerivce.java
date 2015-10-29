package businessLogicsService;

import java.util.Date;
import java.util.List;

import vo.CashRegisterVO;
import vo.PaymentVO;

public interface MoneyBLSerivce {

	
	/**
	 * 按照时间来进行收款单的查看
	 * @param 时间对象
	 * @return 返回相关收款单的VO list
	 */
	public List<CashRegisterVO> checkCash(Date d);
	
	/**
	 * 按照营业厅来进行收款单的查看
	 * @param 营业厅编号
	 * @return 返回相关收款单的VO list
	 */
	public List<CashRegisterVO> checkCash(String institutionId);
	
	/**
	 * 提交付款单单据
	 * @param payment
	 * @return 返回提交的状态
	 */
	public boolean submitPay(PaymentVO payment);
	
	/**
	 * 查看付款单操作 返回所有的付款单的vo对象列表
	 * @return
	 */
	public List<PaymentVO> checkPay();
}
