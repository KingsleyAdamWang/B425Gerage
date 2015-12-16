package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.CashRegisterVO;
import vo.IncomeVO;
import vo.LogVO;
import vo.SendVO;
import businessLogic.logBL.LogBL;
import businessLogicService.businessHallBLService.CashRegisterBLService;

public class CashRegisterController implements CashRegisterBLService {
	private CashRegisterBL crBL;
	private LogBL logBL;
	
	
	public CashRegisterController() throws RemoteException{
		crBL=new CashRegisterBL();
		logBL=new LogBL();
	}

	public String add(IncomeVO incomeVO) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(), "新增收款单"));
		return crBL.add(incomeVO);
	}
	
	public List<SendVO> getSendByStaffID(Date d,String staffID){
		return crBL.getSendByStaffID(d, staffID)
	}


	public String search(String id) {//根据单号查找收款单
		// TODO Auto-generated method stub
		return null;
	}


	public String delete(CashRegisterVO crVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public String submit(CashRegisterVO crVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public double total(List<CashRegisterVO> lists) {//根据收款单列表得到收款总额
		// TODO Auto-generated method stub
		return 0;
	}

	public String add(CashRegisterVO crVO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
