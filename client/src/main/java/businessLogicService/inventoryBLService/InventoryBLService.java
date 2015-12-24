package businessLogicService.inventoryBLService;

import java.rmi.RemoteException;

import vo.InventoryVo.EntryVO;
import vo.InventoryVo.InventoryVO;

public interface InventoryBLService {
	public InventoryVO getInventoryVO(String institutionID);
	
	public String adjust(EntryVO vo) throws RemoteException;
	
	public InventoryVO find(String institutionID);
	
}
