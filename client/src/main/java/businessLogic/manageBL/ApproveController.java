package businessLogic.manageBL;

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
import businessLogicService.manageBLService.ApproveBLService;

public class ApproveController implements ApproveBLService {
	private ApproveBL approveBL;

	public ApproveController() throws RemoteException {
		approveBL = new ApproveBL();
	}

	public List<ArrivalVO> getUnapprovedArrival() {

		return approveBL.getUnapprovedArrival();
	}
	public void setApprovedArrival(ArrivalVO vo) throws RemoteException{
		approveBL.setApprovedArrival(vo);
	}
	public void setAllApprovedArrival() throws RemoteException{
		approveBL.setAllApprovedArrival();
	}
	
	public List<IncomeVO> getUnapprovedIncome(){
		return approveBL.getUnapprovedIncome();
	}
	
	public void setApprovedIncome(IncomeVO vo) throws RemoteException{
		approveBL.setApprovedIncome(vo);
	}
	public void setAllApprovedIncome() throws RemoteException{
		approveBL.setAllApprovedIncome();
	}
	
	public List<DeliveryVO> getUnapprovedDelivery(){
		return approveBL.getUnapprovedDelivery();
	}
	
	public void setApprovedDelivery(DeliveryVO vo) throws RemoteException{
		approveBL.setApprovedDelivery(vo);
	}
	public void setAllApprovedDelivery() throws RemoteException{
		approveBL.setAllApprovedDelivery();
	}
	
	public List<EntryVO> getUnapproveEntry(){
		return approveBL.getUnapproveEntry();
	}
	
	public void setApprovedEntry(EntryVO vo) throws RemoteException{
		approveBL.setApprovedEntry(vo);
	}
	public void setAllApprovedEntry() throws RemoteException{
		approveBL.setAllApprovedEntry();
	}
	
//	public List<IncomeVO> getUnapproveIncome(){
//		return moneyBL.getUnapproved();
//	}
//	
//	public void setApprovedIncome(IncomeVO vo) throws RemoteException{
//		moneyBL.approve(vo.transToPO());
//	}
//	public void setAllApprovedIncome() throws RemoteException{
//		moneyBL.approveAll();
//	}
	
	public List<PaymentVO> getUnapprovePayment(){
		return approveBL.getUnapprovePayment();
	}
	
	public void setApprovedPayment(PaymentVO vo) throws RemoteException{
		approveBL.setApprovedPayment(vo);
	}
	public void setAllApprovedPayment() throws RemoteException{
		approveBL.setAllApprovedPayment();
	}
	
	public List<ReceiveVO> getUnapproveReceive(){
		return approveBL.getUnapproveReceive();
	}
	public void setApprovedReceive(ReceiveVO vo) throws RemoteException{
		approveBL.setApprovedReceive(vo);
	}
	public void setAllApprovedReceive() throws RemoteException{
		approveBL.setAllApprovedReceive();
	}
	
	public List<ShipmentVO> getUnapproveShipment(){
		return approveBL.getUnapproveShipment();
	}
	public void setApprovedShipment(ShipmentVO vo) throws RemoteException{
		approveBL.setApprovedShipment(vo);
	}
	public void setAllApprovedShipment() throws RemoteException{
		approveBL.setAllApprovedShipment();
	}
	
	public List<TransferVO> getUnapproveTransfer(){
		return approveBL.getUnapproveTransfer();
	}
	public void setApprovedTransfer(TransferVO vo) throws RemoteException{
		approveBL.setApprovedTransfer(vo);
	}
	public void setAllApprovedTransfer() throws RemoteException{
		approveBL.setAllApprovedTransfer();
	}

}
