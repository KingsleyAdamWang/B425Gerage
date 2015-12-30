package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.InventoryVo.EntryVO;
import vo.InventoryVo.InventoryVO;
import vo.LogVo.LogVO;
import businessLogic.logBL.LogBL;
import businessLogicService.inventoryBLService.InventoryBLService;
import enumSet.InventoryArea;

public class InventoryController implements InventoryBLService {
	private InventoryBL invBL;
	private LogBL logBL;
	
	public InventoryController() throws RemoteException{
		invBL=new InventoryBL();
		logBL=new LogBL();
	}

	public InventoryVO getInventoryVO(String institutionID){
		return invBL.getInventoryVO(institutionID);
	}
	
	public String adjust(EntryVO vo) throws RemoteException{
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"调整库存"));
		return invBL.adjust(vo.transToPO());
	}
	
	public InventoryVO find(String institutionID){
		return new InventoryVO(invBL.find(institutionID)); 
	}
	
	public List<EntryVO> getEntryList(String institutionID,InventoryArea area) throws RemoteException{
		return invBL.getEntryByInstitutionArea(institutionID, area);
	} 
}
