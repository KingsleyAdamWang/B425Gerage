package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.inventoryPO.ShipmentPO;
import po.managePO.InstitutionPO;
import vo.InventoryVo.ShipmentVO;
import vo.ManageVo.InstitutionVO;
import businessLogic.manageBL.InstitutionBL;
import businessLogic.manageBL.StaffBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.inventoryDataService.ShipmentDataService;
import enumSet.InsType;
import enumSet.InventoryArea;
import enumSet.ReceiptsState;

public class ShipmentBL {
	private ShipmentDataService shipmentDS;
	private List<ShipmentPO> shipmentList;
	private ShipmentPO shipmentPO;

	public ShipmentBL() throws RemoteException {
		try {
			RMIHelper.initShipmentDataService();
			shipmentDS = RMIHelper.getShipmentDataService();
			shipmentList = shipmentDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public String add(ShipmentVO vo) throws RemoteException {
		shipmentPO = vo.transToPO();
		InventoryBL invBL = new InventoryBL();
		for (ShipmentPO temp : shipmentList) {
			if (temp.equals(shipmentPO)) {
				return "存在相同出库单号";
			}
		}

		shipmentPO.setState(ReceiptsState.unapprove);

		shipmentList.add(shipmentPO);
		shipmentDS.add(shipmentPO);
		return invBL.setFree(shipmentPO);
	}

	public String delete(ShipmentVO vo) throws RemoteException {
		shipmentPO = vo.transToPO();
		for (ShipmentPO temp : shipmentList) {
			if (temp.equals(shipmentPO)) {
				shipmentList.remove(shipmentPO);
				shipmentDS.delete(shipmentPO);
				return null;
			}
		}

		return "未找到出库单";
	}

	public String modify(ShipmentVO vo) throws RemoteException {
		ShipmentPO shipmentPO = vo.transToPO();
		for (ShipmentPO temp : shipmentList) {
			if (temp.equals(shipmentPO)) {
				shipmentList.set(shipmentList.indexOf(temp), shipmentPO);
				shipmentDS.modify(shipmentPO);
				return null;
			}
		}

		return "未找到出库单";
	}

	public List<ShipmentPO> getShipmentList() {
		// List<ShipmentVO> result=new ArrayList<ShipmentVO>();
		// for(ShipmentPO temp:shipmentList){
		// result.add(new ShipmentVO(temp));
		// }
		// return result;
		return shipmentList;
	}

	public List<ShipmentPO> getShipmentList(String institutionID)
			throws RemoteException {
		// List<ShipmentPO> shipmentList=shipmentDS.getListByIns(institutionID);
		// List<ShipmentVO> result=new ArrayList<ShipmentVO>();
		// for(ShipmentPO temp:shipmentList){
		// result.add(new ShipmentVO(temp));
		// }
		// return result;
		return shipmentDS.getListByIns(institutionID);
	}

	public ShipmentVO find(String ID) throws RemoteException {
		return new ShipmentVO(shipmentDS.find(ID));
	}

	public List<InstitutionVO> getInstitutionList(String userID)
			throws RemoteException {
		List<InstitutionVO> result = new ArrayList<InstitutionVO>();
		InstitutionBL insBL = new InstitutionBL();
		StaffBL staffBL = new StaffBL();
		String institutionID = (staffBL.getUser(userID).getInstitutionID());
		InstitutionPO institutionPO = insBL.searchInstitution(institutionID);
		List<InstitutionPO> insList = insBL.getInsList();
		for (InstitutionPO temp : insList) {
			if (temp.getCity().equals(institutionPO.getCity())
					&& !temp.getInstitutionID().equals(
							institutionPO.getInstitutionID())) {
				result.add(new InstitutionVO(temp));
			}
		}
		for (InstitutionPO temp : insList) {
			if ((!temp.getName().equals(institutionPO.getName()))
					&& (temp.getType() == InsType.intermediate)) {
				result.add(new InstitutionVO(temp));
			}
		}

		return result;
	}

	public void approve(ShipmentPO po) throws RemoteException {
		shipmentDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		shipmentDS.approvalAll();
	}

	public List<ShipmentVO> getUnapproved() {
		List<ShipmentVO> result = new ArrayList<ShipmentVO>();
		for (ShipmentPO temp : shipmentList) {
			if (temp.getState() == ReceiptsState.unapprove) {
				result.add(new ShipmentVO(temp));
			}
		}
		return result;
	}

}
