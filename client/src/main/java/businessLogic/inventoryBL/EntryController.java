package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.inventoryPO.EntryPO;
import presentation.MainFrame;
import vo.InventoryVo.EntryVO;
import vo.LogVo.LogVO;
import vo.ManageVo.InstitutionVO;
import businessLogic.logBL.LogBL;
import businessLogicService.inventoryBLService.EntryBLService;

public class EntryController implements EntryBLService {
	EntryBL entryBL;
	LogBL logBL;
	public EntryController(){
		try {
			entryBL=new EntryBL();
			logBL=new LogBL();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public String add(EntryVO vo) throws RemoteException{
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增装车单"));
		return entryBL.add(vo);
	}
	
	public String delete(EntryVO vo) throws RemoteException{
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除装车单"));
		return entryBL.delete(vo);
	}
	
	public List<EntryPO> getEntryList(String institutionID) throws RemoteException{
		return entryBL.getEntryList(institutionID);
	}

	public List<InstitutionVO> getInstitutionList(String userID) throws RemoteException{
		return entryBL.getInstitutionList(userID);
	}
}
