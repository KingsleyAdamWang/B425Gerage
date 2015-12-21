package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.List;

import po.IncomePO;
import po.PaymentPO;
import po.ReceivePO;
import po.ShipmentPO;
import po.TransferPO;
import vo.BussinessHallVo.ArrivalVO;
import vo.BussinessHallVo.CashRegisterVO;
import vo.BussinessHallVo.DeliveryVO;
import vo.FinanceVo.IncomeVO;
import vo.FinanceVo.PaymentVO;
import vo.InventoryVo.EntryVO;
import vo.InventoryVo.ShipmentVO;
import businessLogic.businessHallBL.CashRegisterBL;
import businessLogic.businessHallBL.DeliveryBL;
import businessLogic.deliveryBL.ReceiveBL;
import businessLogic.financeBL.MoneyBL;
import businessLogic.financeBL.PaymentBL;
import businessLogic.intermediateBL.TransferBL;
import businessLogic.inventoryBL.EntryBL;
import businessLogic.inventoryBL.ShipmentBL;

public class ApproveBL {
	private businessLogic.businessHallBL.ArrivalBL arrivalBL_B;
	private businessLogic.intermediateBL.ArrivalBL arrivalBL_I;
	private CashRegisterBL crBL;
	private DeliveryBL deliveryBL;
	private EntryBL entryBL;
	private MoneyBL moneyBL;//IncomePO &PaymentPO
	private ReceiveBL receiveBL;
	private ShipmentBL shipmentBL;
	private TransferBL transferBL;
	private PaymentBL paymentBL;
	
	public ApproveBL() throws RemoteException{
		arrivalBL_B=new businessLogic.businessHallBL.ArrivalBL();
		arrivalBL_I=new businessLogic.intermediateBL.ArrivalBL();
		crBL= new CashRegisterBL();
		deliveryBL=new DeliveryBL();
		entryBL=new EntryBL();
		moneyBL=new MoneyBL();
		receiveBL=new ReceiveBL();
		shipmentBL=new ShipmentBL();
		transferBL=new TransferBL();
		paymentBL=new PaymentBL();
		
	}
	
	public void getAllUnapprovedDoc(){
		
	}
	public List<ArrivalVO> getUnapprovedArrival(){
		
		return arrivalBL_B.getUnapproved();
	}
	
	public void setApprovedArrival(ArrivalVO vo) throws RemoteException{
		arrivalBL_B.approve(vo.transToPO());
	}
	public void setAllApprovedArrival() throws RemoteException{
		arrivalBL_B.approveAll();
	}
	
	public List<IncomeVO> getUnapprovedIncome(){
		return crBL.getUnapproved();
	}
	
	public void setApproved(IncomeVO vo) throws RemoteException{
		crBL.approve(vo.transToPO());
	}
	public void setAllApproved() throws RemoteException{
		crBL.approveAll();
	}
	
//	public List<DeliveryVO> getUnapprovedDelivery(){
//		return deliveryBL.getUnapproved();
//	}
//	
//	public void setApprovedDelivery(){
//		deliveryBL.approve();
//	}
//	public void setAllApprovedDelivery(){
//		deliveryBL.approveAll();
//	}
	
	public List<EntryVO> getUnapproveEntry(){
		return entryBL.getUnapproved();
	}
	
	public void setApprovedEntry(EntryVO vo) throws RemoteException{
		entryBL.approve(vo.transToPO());
	}
	public void setAllApprovedEntry() throws RemoteException{
		entryBL.approveAll();
	}
	
//	public List<IncomePO> getUnapproveIncome(){
//		return moneyBL.getUnapproved();
//	}
//	
//	public void setApprovedIncome(){
//		moneyBL.approveIncome();
//	}
//	public void setAllApprovedIncome(){
//		moneyBL.approveAllIncome();
//	}
	
	public List<PaymentVO> getUnapprovePayment(){
		return paymentBL.getUnapproved();
	}
	
	public void setApprovedPayment(PaymentVO vo) throws RemoteException{
		paymentBL.approve(vo.transToPO());
	}
	public void setAllApprovedPayment() throws RemoteException{
		paymentBL.approveAll();
	}
	
//	public List<ReceivePO> getUnapproveReceive(){
//		return receiveBL.getUnapproved();
//	}
//	public void setApprovedReceive(){
//		receiveBL.approve();
//	}
//	public void setAllApprovedReceive(){
//		receiveBL.approveAll();
//	}
	
	public List<ShipmentVO> getUnapproveShipment(){
		return shipmentBL.getUnapproved();
	}
	public void setApprovedShipment(ShipmentVO vo) throws RemoteException{
		shipmentBL.approve(vo.transToPO());
	}
	public void setAllApprovedShipment() throws RemoteException{
		shipmentBL.approveAll();
	}
	
//	public List<TransferPO> getUnapproveTransfer(){
//		return transferBL.getUnapproved();
//	}
//	public void setApprovedTransfer(){
//		transferBL.approve();
//	}
//	public void setAllApprovedTransfer(){
//		transferBL.approveAll();
//	}
}
