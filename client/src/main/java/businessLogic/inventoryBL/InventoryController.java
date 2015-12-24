package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.List;

import po.inventoryPO.InventoryPO;
import vo.InventoryVo.InventoryVO;
import vo.ManageVo.InstitutionVO;
import businessLogicService.inventoryBLService.InventoryBLService;

public class InventoryController implements InventoryBLService {
	private InventoryBL invBL;
	
	InventoryController() throws RemoteException{
		invBL=new InventoryBL();
	}

	public InventoryVO getInventoryVO(String institutionID){
		return invBL.getInventoryVO(institutionID);
	}
	
	public String adjust(InventoryVO vo) throws RemoteException{
		return invBL.adjust(vo.transToPO());
	}
	
	public InventoryVO find(String institutionID){
		return new InventoryVO(invBL.find(institutionID)); 
	}

}
