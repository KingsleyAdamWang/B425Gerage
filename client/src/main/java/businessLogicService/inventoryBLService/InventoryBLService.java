package businessLogicService.inventoryBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.InventoryVo.InventoryVO;
import vo.ManageVo.InstitutionVO;

public interface InventoryBLService {
	public InventoryVO getInventoryVO(String institutionID);
	
	public String adjust(InventoryVO vo) throws RemoteException;
	
	public InventoryVO find(String institutionID);
	
}
