package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.inventoryPO.EntryPO;
import po.managePO.InstitutionPO;
import vo.InventoryVo.EntryVO;
import vo.InventoryVo.ShipmentVO;
import vo.ManageVo.InstitutionVO;
import businessLogic.manageBL.InstitutionBL;
import businessLogic.manageBL.StaffBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.inventoryDataService.EntryDataService;
import enumSet.InsType;
import enumSet.InventoryArea;
import enumSet.ReceiptsState;

public class EntryBL {
	private EntryDataService entryDS;
	private List<EntryPO> entryList;
	private EntryPO entryPO;
	private InventoryBL inventoryBL;

	public EntryBL() throws RemoteException {
		try {
			RMIHelper.initEntryDataService();
			entryDS = RMIHelper.getEntryDataService();
			entryList = entryDS.getEntryList();
			inventoryBL = new InventoryBL();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public String add(EntryVO vo) throws RemoteException {
		entryPO = vo.transToPO();

		for (EntryPO temp : entryList) {
			if (temp.equals(entryPO)) {
				return "存在相同入库单号";
			}
		}

		entryPO.setState(ReceiptsState.unapprove);

		entryList.add(entryPO);
		entryDS.add(entryPO);
		return inventoryBL.setBusy(entryPO);
	}

	public String delete(EntryVO vo) throws RemoteException {
		entryPO = vo.transToPO();
		ShipmentBL shipmentBL = new ShipmentBL();
		ShipmentVO shipmentVO = shipmentBL.find(entryPO.getId());
		for (EntryPO temp : entryList) {
			if (temp.equals(entryPO)) {
				entryList.remove(entryPO);
				entryDS.delete(entryPO);
				return inventoryBL.setFree(shipmentVO.transToPO());
			}
		}

		return "未找到入库单";
	}

	public String modify(EntryVO vo) throws RemoteException {
		entryPO = vo.transToPO();
		for (EntryPO temp : entryList) {
			if (temp.equals(entryPO)) {
				entryList.set(entryList.indexOf(temp), entryPO);
				entryDS.modify(entryPO);
				return null;
			}
		}

		return "未找到入库单";
	}

	public List<InstitutionVO> getInstitutionList(String userID)
			throws RemoteException {
		List<InstitutionVO> result = new ArrayList<InstitutionVO>();
		InstitutionBL insBL = new InstitutionBL();
		StaffBL staffBL = new StaffBL();
		String institutionID = (staffBL.getUser(userID).getInstitutionID());
		InstitutionPO institutionPO = insBL.searchInstitution(institutionID);
		List<InstitutionPO> insList = insBL.getInsList();
		for (InstitutionPO temp : insList) {// 同城的非本机构
			if (temp.getCity().equals(institutionPO.getCity())
					&& !temp.getInstitutionID().equals(
							institutionPO.getInstitutionID())) {
				result.add(new InstitutionVO(temp));
			}
		}
		for (InstitutionPO temp : insList) {// 非同城的中转中心
			if ((!temp.getName().equals(institutionPO.getName()))
					&& (temp.getType() == InsType.intermediate)) {
				result.add(new InstitutionVO(temp));
			}
		}

		return result;
	}

	public List<EntryPO> getEntryList() {
		return entryList;
	}

	public List<EntryPO> getEntryList(String institutionID)
			throws RemoteException {
		return entryDS.getEntryList(institutionID);
	}

	public List<EntryPO> getEntryList(String institutionID, InventoryArea area)
			throws RemoteException {
		List<EntryPO> entryList = getEntryList(institutionID);
		for (EntryPO temp : entryList) {
			if (temp.getArea() != area) {
				entryList.remove(temp);
			}
		}

		return entryList;
	}

	public EntryPO find(String ID) throws RemoteException {
		return entryDS.find(ID);
	}

	public void approve(EntryPO po) throws RemoteException {
		entryDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		entryDS.approvalAll();
	}

	public List<EntryVO> getUnapproved() {
		List<EntryVO> result = new ArrayList<EntryVO>();
		for (EntryPO temp : entryList) {
			if (temp.getState() == ReceiptsState.unapprove) {
				result.add(new EntryVO(temp));
			}
		}
		return result;
	}
}
