package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.List;

import po.inventoryPO.ShipmentPO;
import vo.InventoryVo.ShipmentVO;
import vo.ManageVo.InstitutionVO;
import businessLogicService.inventoryBLService.ShipmentBLService;

public class shipmentController implements ShipmentBLService {
	private ShipmentBL shipmentBL;
	
	public shipmentController() throws RemoteException{
		shipmentBL=new ShipmentBL();
	}
	
	public String add(ShipmentVO vo) throws RemoteException{
		return shipmentBL.add(vo);
	}
	
	public String delete(ShipmentVO vo) throws RemoteException{
		return shipmentBL.delete(vo);
	}
	
//	public List<ShipmentVO> getShipmentList(){
//		return shipmentBL.getShipmentList();
//	}
//	 
//	public List<ShipmentVO> getShipmentList(String institutionID) throws RemoteException{
//		return shipmentBL.getShipmentList(institutionID);
//	}
	
	public ShipmentVO find(String id) throws RemoteException{
		return shipmentBL.find(id);
	}
	
	public List<InstitutionVO> getInstitutionList(String userID) throws RemoteException{
		return shipmentBL.getInstitutionList(userID);
	}
}
