package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.financePO.IncomePO;
import presentation.MainFrame;
import vo.BussinessHallVo.CashRegisterVO;
import vo.DeliverymanVo.SendVO;
import vo.FinanceVo.IncomeVO;
import vo.LogVo.LogVO;
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
	
	public List<SendVO> getSendByStaffID(Date d,String staffID) throws RemoteException{
		return crBL.getSendByStaffID(d, staffID);
	}
	
	public double getAmmounts(List<SendVO> sendList){
		return crBL.getAmmounts(sendList);
	}
	
	public List<IncomePO> getIncomeBetweemDate(Date start ,Date end){
		return crBL.getIncomeBetweemDate(start, end);
	}

	@Override
	public String search(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(CashRegisterVO crVO) {
		// TODO Auto-generated method stub
		return null;
	}


}
