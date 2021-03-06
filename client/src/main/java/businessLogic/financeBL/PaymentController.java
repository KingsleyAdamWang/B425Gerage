package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.financePO.PaymentPO;
import po.logPO.LogPO;
import presentation.MainFrame;
import util.DateUtil;
import vo.FinanceVo.PaymentVO;
import vo.LogVo.LogVO;
import businessLogic.logBL.LogBL;
import businessLogicService.financeBLService.PaymentBLService;

public class PaymentController implements PaymentBLService {
	private PaymentBL paymentBL;
	private LogBL logBL;

	public PaymentController() throws RemoteException {
		paymentBL = new PaymentBL();
		logBL = new LogBL();
	}

	public void addPayment(PaymentVO vo) throws RemoteException {
		logBL.add(new LogVO(new LogPO(DateUtil.stringToDate(DateUtil
				.dateToString(new Date())),
				MainFrame.getUser().getIdentityID(), "增加付款单")));
		paymentBL.addPayment(vo.transToPO());
	}

	public List<PaymentPO> findByDate(Date d) throws RemoteException {
		logBL.add(new LogVO(new LogPO(DateUtil.stringToDate(DateUtil
				.dateToString(new Date())),
				MainFrame.getUser().getIdentityID(), "查找付款单")));
		return paymentBL.findByDate(d);
	}

	public List<PaymentPO> betweenDate(Date start, Date end)
			throws RemoteException {
		logBL.add(new LogVO(new LogPO(DateUtil.stringToDate(DateUtil
				.dateToString(new Date())),
				MainFrame.getUser().getIdentityID(), "查找时间段之间的付款单")));
		return paymentBL.betweenDate(start, end);
	}

	public double getSalaryTotal() throws RemoteException {
		return paymentBL.getSalaryTotal();
	}

	public double getAmmount(List<PaymentVO> paymentList) {
		return paymentBL.getAmmount(paymentList);
	}
}
