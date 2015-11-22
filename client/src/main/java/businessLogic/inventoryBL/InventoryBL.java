package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import dataService.InventoryDataService;
import po.InventoryPO;
import vo.InventoryVO;

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
	
	public List<InventoryPO> checkBetween(Date start, Date end){
		return null;
	}
	public List<InventoryPO> check(){
		return null;
	}
	
	public List<InventoryPO> getMessage(){
		return null;
	}
	
	public String adjust(InventoryVO from, InventoryVO to){
		return null;
	}
	public String init(){
		return null;
	}
}
