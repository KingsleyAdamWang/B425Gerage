package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//import po.PaymentPO;
import po.PaymentPO;
import util.DateUtil;
import vo.PaymentVO;
//import vo.PaymentVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.PaymentDataService;
import enumSet.ReceiptsState;

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
		
		if(po.getComment()==null){
			po.setComment("无");
		}
		
		po.setState(ReceiptsState.unapprove);
		
		paymentList.add(po);
		paymentDS.add(po);
		
	}
	
	public List<PaymentPO> findByDate(Date d) throws RemoteException{
		d=DateUtil.stringToDate(DateUtil.dateToString(d));
		return paymentDS.find(d);
	}

	public List<PaymentPO> betweenDate(Date start,Date end) {
		List<PaymentPO> payments=new ArrayList<PaymentPO>();
		for(PaymentPO temp: paymentList){
			if(temp.getD().after(start)&&temp.getD().before(end)){
				payments.add(temp);
			}
		}
		return payments;
	}

	public void approve(PaymentPO po) throws RemoteException {
		paymentDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		paymentDS.approvalAll();
	}

	public List<PaymentVO> getUnapproved() {
		List<PaymentVO> result=new ArrayList<PaymentVO>();
		for(PaymentPO temp: paymentList){
			if(temp.getState()==ReceiptsState.unapprove){
				result.add(new PaymentVO(temp));
			}
		}
		return result;
	}
}
