package businessLogicService.inventoryBLService;

import java.util.Date;
import java.util.List;

import po.inventoryPO.InventoryPO;
import vo.InventoryVo.InventoryVO;

public interface InventoryBLService {
	public List<InventoryPO> checkBetween(Date start,Date end);

	public List<InventoryPO> check();
	
	public List<InventoryPO> getMessage();
	
	public String adjust(InventoryVO from, InventoryVO to);
	
	public String init();
}
