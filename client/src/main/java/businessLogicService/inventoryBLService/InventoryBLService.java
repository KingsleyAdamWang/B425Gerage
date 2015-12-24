package businessLogicService.inventoryBLService;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.inventoryPO.InventoryPO;
import vo.InventoryVo.InventoryVO;

public interface InventoryBLService {
	public InventoryVO getInventoryVO(String institutionID);
	
	public String adjust(InventoryVO vo) throws RemoteException;
	
	public InventoryVO find(String institutionID);
	
	
}
