package businessLogic.manageBL;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.InventoryVo.InventoryVO;
import vo.LogVo.LogVO;
import vo.ManageVo.InstitutionVO;
import businessLogic.logBL.LogBL;
import businessLogicService.manageBLService.InstitutionBLService;

public class InstitutionController implements InstitutionBLService {
	private InstitutionBL insBL;
	private LogBL logBL;

	public InstitutionController() throws RemoteException {
		insBL = new InstitutionBL();
		logBL = new LogBL();
	}

	public List<InstitutionVO> show() throws IOException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"查询机构信息"));
		return insBL.show();
	}

	public String addIns(InstitutionVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增机构信息"));
		return insBL.addIns(vo);
	}

	public String addIns(InstitutionVO vo, InventoryVO ivo)
			throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增机构信息"));
		return insBL.addIns(vo, ivo);
	}

	public String deleteIns(InstitutionVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除机构信息"));
		return insBL.deleteIns(vo);
	}

	public String modify(String institutionID, String newName)
			throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"修改机构名称"));
		return insBL.modify(institutionID, newName);
	}

	// 用于更改inventoryPO，id与institutionPO相同
	public String modify(String inventoryID, InventoryVO vo)
			throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"修改仓库信息"));
		return insBL.modify(inventoryID, vo);
	}

	public InstitutionVO searchInstitution(String institutionID) {
		return insBL.getInstitutionVO(institutionID);
	}

	public InventoryVO searchInventory(String inventoryID)
			throws RemoteException {
		return insBL.searchInventory(inventoryID);
	}

	// 下面这个别管，没用
	public InstitutionVO search(String institutionID) {
		// TODO Auto-generated method stub
		return null;
	}

}
