package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import dataService.inventoryDataService.InventoryDataService;
import po.EntryPO;
import po.InventoryPO;
import vo.InventoryVo.InventoryVO;

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
			if(!((!temp.getDate().before(start))&&temp.getDate().before(end))){
				entryList.remove(temp);
			}
		}
		return entryList;
	}
	
	public String add(EntryPO po){
		
	}
	
	public List<InventoryPO> check(){
	
		return null;
	}
	
	public boolean alarm(InventoryPO po){
		//TODO如果某仓库po的单据数超过总容量，则返回false
		return true;
	}
	
	public List<InventoryPO> getMessage(){
		return null;
	}
	
	public String adjust(InventoryVO from, InventoryVO to) throws RemoteException{
		InventoryPO po1=from.transToPO();
		InventoryPO po2=from.transToPO();
	
		for(InventoryPO temp:invList){
			if(temp.equals(po1)){
				invDS.modify(po2);
				invList=invDS.getInventoryList();
			}
		}
		return null;
	}
	public String init(){
		return null;
	}
}
