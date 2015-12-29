package businessLogicService.manageBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.BussinessHallVo.ArrivalVO;
import vo.BussinessHallVo.DeliveryVO;
import vo.DeliverymanVo.ReceiveVO;
import vo.FinanceVo.IncomeVO;
import vo.FinanceVo.PaymentVO;
import vo.IntermediateVo.TransferVO;
import vo.InventoryVo.EntryVO;
import vo.InventoryVo.ShipmentVO;

/**
 * 
 * 实现总经理审批各类单据的业务逻辑接口
 *
 */
public interface ApproveBLService {
	public List<ArrivalVO> getUnapprovedArrival();
	
	public void setApprovedArrival(ArrivalVO vo) throws RemoteException;
	
	public void setAllApprovedArrival() throws RemoteException;
	
	public List<IncomeVO> getUnapprovedIncome();
	
	public void setApprovedIncome(IncomeVO vo) throws RemoteException;
	
	public void setAllApprovedIncome() throws RemoteException;
	
	public List<DeliveryVO> getUnapprovedDelivery();
	
	public void setApprovedDelivery(DeliveryVO vo) throws RemoteException;
	
	public void setAllApprovedDelivery() throws RemoteException;
	
	public List<EntryVO> getUnapproveEntry();

	public void setApprovedEntry(EntryVO vo) throws RemoteException;
	
	public void setAllApprovedEntry() throws RemoteException;
	
	public List<PaymentVO> getUnapprovePayment();
	
	public void setApprovedPayment(PaymentVO vo) throws RemoteException;
	
	public void setAllApprovedPayment() throws RemoteException;
	
	public List<ReceiveVO> getUnapproveReceive();
	
	public void setApprovedReceive(ReceiveVO vo) throws RemoteException;
	
	public void setAllApprovedReceive() throws RemoteException;
	
	public List<ShipmentVO> getUnapproveShipment();
	
	public void setApprovedShipment(ShipmentVO vo) throws RemoteException;
	
	public void setAllApprovedShipment() throws RemoteException;
	
	public List<TransferVO> getUnapproveTransfer();
	
	public void setApprovedTransfer(TransferVO vo) throws RemoteException;
	
	public void setAllApprovedTransfer() throws RemoteException;
}
