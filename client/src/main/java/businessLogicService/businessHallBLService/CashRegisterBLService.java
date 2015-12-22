package businessLogicService.businessHallBLService;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import vo.BussinessHallVo.CashRegisterVO;
import vo.DeliverymanVo.SendVO;
import vo.FinanceVo.IncomeVO;

/**
 * 
 * 实现收款单的业务逻辑接口
 *
 */
public interface CashRegisterBLService {
	public String add(IncomeVO incomeVO) throws RemoteException;
	
	public List<SendVO> getSendByStaffID(Date d,String staffID) throws RemoteException;
	
	public double getAmmounts(List<SendVO> sendList);
	
	
	public String search(String id);

	
	public String delete(CashRegisterVO crVO); 

}
