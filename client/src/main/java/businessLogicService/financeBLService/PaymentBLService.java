package businessLogicService.financeBLService;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.PaymentPO;
import vo.FinanceVo.PaymentVO;

public interface PaymentBLService {

	public void addPayment(PaymentVO vo)throws RemoteException;

	public List<PaymentPO> findByDate(Date d)throws RemoteException;

	public List<PaymentPO> betweenDate(Date start, Date end)throws RemoteException;
}
