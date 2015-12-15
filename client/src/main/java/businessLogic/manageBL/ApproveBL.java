package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.List;

import po.IncomePO;
import po.PaymentPO;
import po.ReceivePO;
import po.ShipmentPO;
import po.TransferPO;
import vo.ArrivalVO;
import vo.CashRegisterVO;
import vo.DeliveryVO;
import vo.EntryVO;
import businessLogic.businessHallBL.CashRegisterBL;
import businessLogic.businessHallBL.DeliveryBL;
import businessLogic.deliveryBL.ReceiveBL;
import businessLogic.financeBL.MoneyBL;
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
		
	}
	
	public void getAllUnapprovedDoc(){
		
	}
	public List<ArrivalVO> getUnapprovedArrival(){
		
		return null;
	}
	
	public void setApprovedArrival(){
		arrivalBL_B.approve();
	}
	public void setAllApprovedArrival(){
		arrivalBL_B.approveAll();
	}
	
	public List<CashRegisterVO> getUnapprovedCashRegister(){
		return null;
	}
	
	public void setApprovedCashRegister(){
		crBL.approve();
	}
	public void setAllApprovedCashRegister(){
		crBL.approveAll();
	}
	
	public List<DeliveryVO> getUnapprovedDelivery(){
		return null;
	}
	
	public void setApprovedDelivery(){
		deliveryBL.approve();
	}
	public void setAllApprovedDelivery(){
		deliveryBL.approveAll();
	}
	
	public List<EntryVO> getUnapproveEntry(){
		return null;
	}
	
	public void setApprovedEntry(){
		entryBL.approve();
	}
	public void setAllApprovedEntry(){
		entryBL.approveAll();
	}
	
	public List<IncomePO> getUnapproveIncome(){
		return null;
	}
	
	public void setApprovedIncome(){
		moneyBL.approveIncome();
	}
	public void setAllApprovedIncome(){
		moneyBL.approveAllIncome();
	}
	
	public List<PaymentPO> getUnapprovePayment(){
		return null;
	}
	
	public void setApprovedCashRegister(){
		crBL.approve();
	}
	public void setAllApprovedCashRegister(){
		crBL.approveAll();
	}
	
	public List<ReceivePO> getUnapproveReceive(){
		return null;
	}
	
	public List<ShipmentPO> getUnapproveShipment(){
		return null;
	}
	
	public List<TransferPO> getUnapproveTransfer(){
		return null;
	}
}
