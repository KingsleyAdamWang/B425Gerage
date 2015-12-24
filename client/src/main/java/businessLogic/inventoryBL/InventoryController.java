package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.List;

import vo.InventoryVo.EntryVO;
import vo.InventoryVo.InventoryVO;
import businessLogicService.inventoryBLService.InventoryBLService;
import enumSet.InventoryArea;

public class InventoryController implements InventoryBLService {
	private InventoryBL invBL;
	
	public InventoryController() throws RemoteException{
		invBL=new InventoryBL();
	}

	public InventoryVO getInventoryVO(String institutionID){
		return invBL.getInventoryVO(institutionID);
	}
	
	public String adjust(EntryVO vo) throws RemoteException{
		return invBL.adjust(vo.transToPO());
	}
	
	public InventoryVO find(String institutionID){
		return new InventoryVO(invBL.find(institutionID)); 
	}
	
	public List<EntryVO> getEntryList(String institutionID,InventoryArea area) throws RemoteException{
		return invBL.getEntryByInstitutionArea(institutionID, area);
	} 
}
