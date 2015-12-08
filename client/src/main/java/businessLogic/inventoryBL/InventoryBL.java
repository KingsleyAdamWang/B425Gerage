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
		//缺少入库时间的量
		for(InventoryPO temp: invList){
			if(temp.g)
		}
		return null;
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
	
	public String adjust(InventoryVO from, InventoryVO to){
		return null;
	}
	public String init(){
		return null;
	}
}
