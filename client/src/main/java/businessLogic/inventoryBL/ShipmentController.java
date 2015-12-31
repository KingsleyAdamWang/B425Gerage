package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.InventoryVo.ShipmentVO;
import vo.LogVo.LogVO;
import vo.ManageVo.InstitutionVO;
import businessLogic.logBL.LogBL;
import businessLogicService.inventoryBLService.ShipmentBLService;

public class ShipmentController implements ShipmentBLService {
	private ShipmentBL shipmentBL;
	private LogBL logBL;

	public ShipmentController() throws RemoteException {
		shipmentBL = new ShipmentBL();
		logBL = new LogBL();
	}

	public String add(ShipmentVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增出库单"));
		return shipmentBL.add(vo);
	}

	public String delete(ShipmentVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除出库单"));
		return shipmentBL.delete(vo);
	}

	// public List<ShipmentVO> getShipmentList(){
	// return shipmentBL.getShipmentList();
	// }
	//
	// public List<ShipmentVO> getShipmentList(String institutionID) throws
	// RemoteException{
	// return shipmentBL.getShipmentList(institutionID);
	// }

	public ShipmentVO find(String id) throws RemoteException {
		return shipmentBL.find(id);
	}

	public List<InstitutionVO> getInstitutionList(String userID)
			throws RemoteException {
		return shipmentBL.getInstitutionList(userID);
	}

	public List<ShipmentVO> getUnapproved() {
		return shipmentBL.getUnapproved();
	}
}
