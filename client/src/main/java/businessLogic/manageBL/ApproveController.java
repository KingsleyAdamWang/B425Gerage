package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.List;

import vo.BussinessHallVo.ArrivalVO;
import vo.BussinessHallVo.DeliveryVO;
import vo.BussinessHallVo.EntruckVO;
import vo.DeliverymanVo.ReceiveVO;
import vo.DeliverymanVo.SendVO;
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

	// 寄件单
	public List<SendVO> getUnapproveSend() {
		return approveBL.getUnapproveSend();
	}

	public void setApprovedSend(SendVO vo) throws RemoteException {
		approveBL.setApprovedSend(vo);
	}

	public void setAllApprovedSend() throws RemoteException {
		approveBL.setAllApprovedSend();
	}

	public void modifySend(SendVO vo) throws RemoteException {
		approveBL.modifySend(vo);
	}

	// 到达单
	public List<ArrivalVO> getUnapprovedArrival() {
		return approveBL.getUnapprovedArrival();
	}

	public void setApprovedArrival(ArrivalVO vo) throws RemoteException {
		approveBL.setApprovedArrival(vo);
	}

	public void setAllApprovedArrival() throws RemoteException {
		approveBL.setAllApprovedArrival();
	}

	public void modifyArrival(ArrivalVO arrivalVO) throws RemoteException {
		approveBL.modifyArrival(arrivalVO);
	}

	// 收款单
	public List<IncomeVO> getUnapprovedIncome() {
		return approveBL.getUnapprovedIncome();
	}

	public void setApprovedIncome(IncomeVO vo) throws RemoteException {
		approveBL.setApprovedIncome(vo);
	}

	public void setAllApprovedIncome() throws RemoteException {
		approveBL.setAllApprovedIncome();
	}

	public void modifyIncome(IncomeVO vo) throws RemoteException {
		approveBL.modifyIncome(vo);
	}

	// 派件单
	public List<DeliveryVO> getUnapprovedDelivery() {
		return approveBL.getUnapprovedDelivery();
	}

	public void setApprovedDelivery(DeliveryVO vo) throws RemoteException {
		approveBL.setApprovedDelivery(vo);
	}

	public void setAllApprovedDelivery() throws RemoteException {
		approveBL.setAllApprovedDelivery();
	}

	public void modifyDelivery(DeliveryVO vo) throws RemoteException {
		approveBL.modifyDelivery(vo);
	}

	// 装车单
	public List<EntruckVO> getUnapproveEntruck() {
		return approveBL.getUnapproveEntruck();
	}

	public void setApprovedEntruck(EntruckVO vo) throws RemoteException {
		approveBL.setApprovedEntruck(vo);
	}

	public void setAllApprovedEntruck() throws RemoteException {
		approveBL.setAllApprovedEntruck();
	}

	public void modifyEntruck(EntruckVO vo) throws RemoteException {
		approveBL.modifyEntruck(vo);
	}

	// 入库单
	public List<EntryVO> getUnapproveEntry() {
		return approveBL.getUnapproveEntry();
	}

	public void setApprovedEntry(EntryVO vo) throws RemoteException {
		approveBL.setApprovedEntry(vo);
	}

	public void setAllApprovedEntry() throws RemoteException {
		approveBL.setAllApprovedEntry();
	}

	public void modifyEntry(EntryVO vo) throws RemoteException {
		approveBL.modifyEntry(vo);
	}

	// public List<IncomeVO> getUnapproveIncome(){
	// return moneyBL.getUnapproved();
	// }
	//
	// public void setApprovedIncome(IncomeVO vo) throws RemoteException{
	// moneyBL.approve(vo.transToPO());
	// }
	// public void setAllApprovedIncome() throws RemoteException{
	// moneyBL.approveAll();
	// }

	// 付款单
	public List<PaymentVO> getUnapprovePayment() {
		return approveBL.getUnapprovePayment();
	}

	public void setApprovedPayment(PaymentVO vo) throws RemoteException {
		approveBL.setApprovedPayment(vo);
	}

	public void setAllApprovedPayment() throws RemoteException {
		approveBL.setAllApprovedPayment();
	}

	public void modifyPayment(PaymentVO vo) throws RemoteException {
		approveBL.modifyPayment(vo);
	}

	// 收件单
	public List<ReceiveVO> getUnapproveReceive() {
		return approveBL.getUnapproveReceive();
	}

	public void setApprovedReceive(ReceiveVO vo) throws RemoteException {
		approveBL.setApprovedReceive(vo);
	}

	public void setAllApprovedReceive() throws RemoteException {
		approveBL.setAllApprovedReceive();
	}

	public void modifyReceive(ReceiveVO vo) throws RemoteException {
		approveBL.modifyReceive(vo);
	}

	// 出库单
	public List<ShipmentVO> getUnapproveShipment() {
		return approveBL.getUnapproveShipment();
	}

	public void setApprovedShipment(ShipmentVO vo) throws RemoteException {
		approveBL.setApprovedShipment(vo);
	}

	public void setAllApprovedShipment() throws RemoteException {
		approveBL.setAllApprovedShipment();
	}

	public void modifyShipment(ShipmentVO vo) throws RemoteException {
		approveBL.modifyShipment(vo);
	}

	// 中转单
	public List<TransferVO> getUnapproveTransfer() {
		return approveBL.getUnapproveTransfer();
	}

	public void setApprovedTransfer(TransferVO vo) throws RemoteException {
		approveBL.setApprovedTransfer(vo);
	}

	public void setAllApprovedTransfer() throws RemoteException {
		approveBL.setAllApprovedTransfer();
	}

	public void modifyTransfer(TransferVO vo) throws RemoteException {
		approveBL.modifyTransfer(vo);
	}
}
