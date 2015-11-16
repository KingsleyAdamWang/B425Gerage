package businessLogicService.inventoryBLService;

import java.util.Date;
import java.util.List;
import businessLogic.inventoryBL.inventoryPositionVO;
import po.InventoryPO;

public interface InventoryBLService {
	public List<InventoryPO> checkBetween(Date start,Date end);

	public List<InventoryPO> check();
	
	public List<InventoryPO> getMessage();
	
	public boolean adjust(inventoryPositionVO from, inventoryPositionVO to);
	
	public boolean init();
}
