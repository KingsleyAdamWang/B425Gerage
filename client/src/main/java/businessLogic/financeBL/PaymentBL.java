package businessLogic.financeBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




//import po.PaymentPO;
import po.financePO.PaymentPO;
import po.managePO.SalaryPO;
import util.DateUtil;
import vo.AdminVo.UserVO;
import vo.FinanceVo.PaymentVO;
import businessLogic.manageBL.SalaryBL;
import businessLogic.manageBL.StaffBL;
//import vo.PaymentVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.financeDataService.PaymentDataService;
import enumSet.Position;
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
	
	public List<PaymentPO> getPaymentList(){
		return paymentList;
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
			//别给我什么 after 和 before
			if(temp.getD().getTime()>=start.getTime()&&temp.getD().getTime()<=end.getTime()){
				payments.add(temp);
			}
		}
		return payments;
	}
	
	public double getAmmount(List<PaymentVO> paymentList){
		double ammount=0;
		for(PaymentVO temp:paymentList){
			ammount=ammount+temp.payment;
		}
		return ammount;
	}
	
	public double getSalaryTotal() throws RemoteException{
		double result=0;
		StaffBL staffBL=new StaffBL();
		List<UserVO> userList =staffBL.getUsers();
		int delivery=0;
		int businessHall=0;
		int intermidate=0;
		int inventory=0;
		int financeH=0;
		int financeL=0;
		int mananger=0;
		int admin=0;
		
		for(UserVO temp:userList){
			Position position=temp.getWork();
			
			switch(position.getPositionString()){
			case("快递员"):delivery++;break;
			case("营业厅业务人员"):businessHall++;break;
			case("中转中心业务人员"):intermidate++;break;
			case("中转中心仓库管理员"):inventory++;break;
			case("财务人员（高）"):financeH++;break;
			case("财务人员（低）"):financeL++;break;
			case("总经理"):mananger++;break;
			}
		}
		SalaryBL salaryBL=new SalaryBL();
		SalaryPO salaryPO= salaryBL.getSalaryPO();
		result=delivery*salaryBL.getSalaryByWork("快递员")+
				businessHall*salaryBL.getSalaryByWork("营业厅业务人员")+
				intermidate*salaryBL.getSalaryByWork("中转中心业务人员")+
				inventory*salaryBL.getSalaryByWork("中转中心仓库管理员")+
				financeH*salaryBL.getSalaryByWork("财务人员（高）")+
				financeL*salaryBL.getSalaryByWork("财务人员（低）")+
				mananger*salaryBL.getSalaryByWork("总经理");
	
		return result;
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
