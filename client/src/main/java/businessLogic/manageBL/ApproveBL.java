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
import businessLogic.businessHallBL.CashRegisterBL;
import businessLogic.businessHallBL.DeliveryBL;
import businessLogic.businessHallBL.EntruckBL;
import businessLogic.deliveryBL.ReceiveBL;
import businessLogic.deliveryBL.SendBL;
import businessLogic.financeBL.MoneyBL;
import businessLogic.financeBL.PaymentBL;
import businessLogic.intermediateBL.TransferBL;
import businessLogic.inventoryBL.EntryBL;
import businessLogic.inventoryBL.ShipmentBL;

public class ApproveBL {
	private SendBL sendBL;
	private businessLogic.businessHallBL.ArrivalBL arrivalBL_B;
	private businessLogic.intermediateBL.ArrivalBL arrivalBL_I;
	private CashRegisterBL crBL;
	private DeliveryBL deliveryBL;
	private EntruckBL entruckBL;
	private EntryBL entryBL;
	private MoneyBL moneyBL;// IncomePO &PaymentPO
	private ReceiveBL receiveBL;
	private ShipmentBL shipmentBL;
	private TransferBL transferBL;
	private PaymentBL paymentBL;

	public ApproveBL() throws RemoteException {
		sendBL = new SendBL();
		arrivalBL_B = new businessLogic.businessHallBL.ArrivalBL();
		arrivalBL_I = new businessLogic.intermediateBL.ArrivalBL();
		crBL = new CashRegisterBL();
		deliveryBL = new DeliveryBL();
		entruckBL = new EntruckBL();
		entryBL = new EntryBL();
		moneyBL = new MoneyBL();
		receiveBL = new ReceiveBL();
		shipmentBL = new ShipmentBL();
		transferBL = new TransferBL();
		paymentBL = new PaymentBL();

	}

	public void getAllUnapprovedDoc() {

	}

	// 寄件单
	public List<SendVO> getUnapproveSend() {
		return sendBL.getUnapproved();
	}

	public void setApprovedSend(SendVO vo) throws RemoteException {
		sendBL.approve(vo.transToPO());
	}

	public void setAllApprovedSend() throws RemoteException {
		sendBL.approveAll();
	}

	public void modifySend(SendVO vo) throws RemoteException {
		sendBL.modify(vo);
	}

	// 到达单
	public List<ArrivalVO> getUnapprovedArrival() {

		return arrivalBL_B.getUnapproved();
	}

	public void setApprovedArrival(ArrivalVO vo) throws RemoteException {
		arrivalBL_B.approve(vo.transToPO());
	}

	public void setAllApprovedArrival() throws RemoteException {
		arrivalBL_B.approveAll();
	}

	public void modifyArrival(ArrivalVO arrivalVO) throws RemoteException {
		arrivalBL_B.modify(arrivalVO);
	}

	// 收款单
	public List<IncomeVO> getUnapprovedIncome() {
		return crBL.getUnapproved();
	}

	public void setApprovedIncome(IncomeVO vo) throws RemoteException {
		crBL.approve(vo.transToPO());
	}

	public void setAllApprovedIncome() throws RemoteException {
		crBL.approveAll();
	}

	public void modifyIncome(IncomeVO vo) throws RemoteException {
		crBL.modify(vo.transToPO());
	}

	// 派件单
	public List<DeliveryVO> getUnapprovedDelivery() {
		return deliveryBL.getUnapproved();
	}

	public void setApprovedDelivery(DeliveryVO vo) throws RemoteException {
		deliveryBL.approve(vo.transToPO());
	}

	public void setAllApprovedDelivery() throws RemoteException {
		deliveryBL.approveAll();
	}

	public void modifyDelivery(DeliveryVO vo) throws RemoteException {
		deliveryBL.modify(vo);
	}

	// 装车单
	public List<EntruckVO> getUnapproveEntruck() {
		return entruckBL.getUnapproved();
	}

	public void setApprovedEntruck(EntruckVO vo) throws RemoteException {
		entruckBL.approve(vo.transToPO());
	}

	public void setAllApprovedEntruck() throws RemoteException {
		entruckBL.approveAll();
	}

	public void modifyEntruck(EntruckVO vo) throws RemoteException {
		entruckBL.modify(vo);
	}

	// 入库单
	public List<EntryVO> getUnapproveEntry() {
		return entryBL.getUnapproved();
	}

	public void setApprovedEntry(EntryVO vo) throws RemoteException {
		entryBL.approve(vo.transToPO());
	}

	public void setAllApprovedEntry() throws RemoteException {
		entryBL.approveAll();
	}

	public void modifyEntry(EntryVO vo) throws RemoteException {
		entryBL.modify(vo);
	}

	// public List<IncomeVO> getUnapproveIncome(){
	// return moneyBL.getUnapproved();
	// }

	// public void setApprovedIncome(IncomeVO vo) throws RemoteException{
	// moneyBL.approve(vo.transToPO());
	// }
	// public void setAllApprovedIncome() throws RemoteException{
	// moneyBL.approveAll();
	// }

	// 付款单
	public List<PaymentVO> getUnapprovePayment() {
		return paymentBL.getUnapproved();
	}

	public void setApprovedPayment(PaymentVO vo) throws RemoteException {
		paymentBL.approve(vo.transToPO());
	}

	public void setAllApprovedPayment() throws RemoteException {
		paymentBL.approveAll();
	}

	public void modifyPayment(PaymentVO vo) throws RemoteException {
		paymentBL.modify(vo);
	}

	// 收件单
	public List<ReceiveVO> getUnapproveReceive() {
		return receiveBL.getUnapproved();
	}

	public void setApprovedReceive(ReceiveVO vo) throws RemoteException {
		receiveBL.approve(vo.transToPO());
	}

	public void setAllApprovedReceive() throws RemoteException {
		receiveBL.approveAll();
	}

	public void modifyReceive(ReceiveVO vo) throws RemoteException {
		receiveBL.modify(vo);
	}

	// 出库单
	public List<ShipmentVO> getUnapproveShipment() {
		return shipmentBL.getUnapproved();
	}

	public void setApprovedShipment(ShipmentVO vo) throws RemoteException {
		shipmentBL.approve(vo.transToPO());
	}

	public void setAllApprovedShipment() throws RemoteException {
		shipmentBL.approveAll();
	}

	public void modifyShipment(ShipmentVO vo) throws RemoteException {
		shipmentBL.modify(vo);
	}

	// 中转单
	public List<TransferVO> getUnapproveTransfer() {
		return transferBL.getUnapproved();
	}

	public void setApprovedTransfer(TransferVO vo) throws RemoteException {
		transferBL.approve(vo.transToPO());
	}

	public void setAllApprovedTransfer() throws RemoteException {
		transferBL.approveAll();
	}

	public void modifyTransfer(TransferVO vo) throws RemoteException {
		transferBL.modify(vo);
	}
}
