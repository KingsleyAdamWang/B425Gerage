package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.inventoryPO.EntryPO;
import po.inventoryPO.InventoryPO;
import po.inventoryPO.ShipmentPO;
import vo.InventoryVo.InventoryVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.inventoryDataService.InventoryDataService;

public class InventoryBL {
	InventoryDataService invDS;
	List<InventoryPO> invList;
	
	public  InventoryBL() throws RemoteException {
		try {
			RMIHelper.initInventoryDataService();
			invDS = RMIHelper.getInventoryDataService();
			invList = invDS.getInventoryList();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public InventoryVO getInventoryVO(String institutionID){
		return new InventoryVO(getInventoryPO(institutionID));
	}
	
	//根据机构ID得到一个库存PO
	public InventoryPO getInventoryPO(String institutionID){
		for(InventoryPO temp: invList){
			if(temp.getInstitutionID()==institutionID){
				return temp;
			}
		}
		return null;
	}
	
	public List<EntryPO> checkBetween(Date start, Date end) throws RemoteException{
		EntryBL entryBL=new EntryBL();
		List<EntryPO> entryList=entryBL.getEntryList();
		for(EntryPO temp: entryList){
			if(temp.getDate().getTime()>start.getTime()&&temp.getDate().getTime()<end.getTime()){
				entryList.remove(temp);
			}
		}
		return entryList;
	}
	
//	public boolean isBusy(EntryPO entryPO){
//		InventoryPO inventoryPO=find(entryPO.getInstitutionID());
//		int busyUnit=0;
//		return inventoryPO.alert(entryPO.getArea(), 0.9);
//		busyUnit=entryPO.get
//		return false;
//	}
	
	public String setBusy(EntryPO entryPO) throws RemoteException{
		InventoryPO inventoryPO=find(entryPO.getInstitutionID());
		int oldIndex=invList.indexOf(inventoryPO);
		int Unit=0;
		Unit=(entryPO.getPlace()-1)*(entryPO.getRow())+(entryPO.getRow()-1)*entryPO.getPlace()+entryPO.getPlace();
		if(inventoryPO.isBusy(entryPO.getArea(), Unit)){
			return "该位已被占用";
		}else{
			inventoryPO.setIsBusy(entryPO.getArea(), Unit, true);
			invList.set(oldIndex, inventoryPO);
			modify(inventoryPO);
			return null;
		}
	}
	
	public String setFree(ShipmentPO shipmentPO) throws RemoteException{
		InventoryPO inventoryPO=find(shipmentPO.getInstitutionID());
		int oldIndex=invList.indexOf(inventoryPO);
		EntryBL entryBL=new EntryBL();
		EntryPO entryPO=entryBL.find(shipmentPO.getId());
		int Unit=0;
		Unit=(entryPO.getPlace()-1)*(entryPO.getRow())+(entryPO.getRow()-1)*entryPO.getPlace()+entryPO.getPlace();
		if(!inventoryPO.isBusy(entryPO.getArea(), Unit)){
			return "该位已为空";
		}else{
			inventoryPO.setIsBusy(entryPO.getArea(), Unit, false);
			invList.set(oldIndex, inventoryPO);
			modify(inventoryPO);
			return null;
		}
	}
	
	public String modify(InventoryPO po) throws RemoteException{
		InventoryPO oldInv=find(po.getInstitutionID());
		invList.set(invList.indexOf(oldInv), po);
		invDS.modify(po);
		return null;
	}
	

	
	public String adjust( InventoryPO to) throws RemoteException{
		InventoryPO from=find(to.getInstitutionID());
		
		for(InventoryPO temp:invList){
			if(temp.equals(from)){
				invList.set(invList.indexOf(temp), to);
				invDS.modify(to);
			}
		}
		return null;
	}
	
	public InventoryPO find(String institutionID){
		for(InventoryPO temp: invList){
			if(temp.getInstitutionID().equals(institutionID)){
				return temp;
			}
		}
		return null;
	}
	
}
