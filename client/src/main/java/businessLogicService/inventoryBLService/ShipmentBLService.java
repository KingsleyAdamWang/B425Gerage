package businessLogicService.inventoryBLService;

import vo.ShipmentVO;

public interface ShipmentBLService {
	public void add(String id);

	public void end();

	public boolean submit(ShipmentVO vo);
}
