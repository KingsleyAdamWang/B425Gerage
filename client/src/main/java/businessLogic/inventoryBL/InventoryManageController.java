package businessLogic.inventoryBL;

import java.util.Date;
import java.util.List;
import po.InventoryPO;
import businessLogicService.inventoryBLService.InventoryBLService;

public class InventoryManageController implements InventoryBLService {

	public List<InventoryPO> checkBetween(Date start,Date end){
		return null;
	}
	
	public List<InventoryPO> check(){
		return null;
	}
	
	public List<InventoryPO> getMessage(){
		return null;
	}
	
	public boolean adjust(inventoryPositionVO from, inventoryPositionVO to){
		return false;
	}
	
	public boolean init(){
		return false;
	}

}
