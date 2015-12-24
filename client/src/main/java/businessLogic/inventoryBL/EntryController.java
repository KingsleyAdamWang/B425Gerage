package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.List;

import po.inventoryPO.EntryPO;
import vo.InventoryVo.EntryVO;
import vo.ManageVo.InstitutionVO;
import businessLogicService.inventoryBLService.EntryBLService;

public class EntryController implements EntryBLService {
	EntryBL entryBL;
	
	public EntryController(){
		try {
			entryBL=new EntryBL();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public String add(EntryVO vo) throws RemoteException{
		return entryBL.add(vo);
	}
	
	public String delete(EntryVO vo) throws RemoteException{
		return entryBL.delete(vo);
	}
	
	public List<EntryPO> getEntryList(String institutionID) throws RemoteException{
		return entryBL.getEntryList(institutionID);
	}

	public List<InstitutionVO> getInstitutionList(String userID) throws RemoteException{
		return entryBL.getInstitutionList(userID);
	}
	

}
