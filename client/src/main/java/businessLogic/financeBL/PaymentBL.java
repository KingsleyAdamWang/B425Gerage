package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.PaymentPO;
import util.DateUtil;
import client.ClientInitException;
import client.RMIHelper;
import dataService.PaymentDataService;

public class PaymentBL {
	PaymentDataService paymentDS;
	List<PaymentPO> paymentList;
	
	public PaymentBL() throws RemoteException {
		try {
			RMIHelper.initPaymentDataService();
			paymentDS = RMIHelper.getPaymentDataService();
			paymentList = paymentDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public void addPayment(PaymentPO po) throws RemoteException{
		
		paymentList.add(po);
		paymentDS.add(po);
		
	}
	
	public List<PaymentPO> findByDate(Date d) throws RemoteException{
		d=DateUtil.stringToDate(DateUtil.dateToString(d));
		return paymentDS.find(d);
	}

	public List<PaymentPO> betweenDate(Date start,Date end) {
		for(PaymentPO temp: paymentList){
			if()
		}
		return null;
	}
}
