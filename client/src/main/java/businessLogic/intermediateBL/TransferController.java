package businessLogic.intermediateBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.IntermediateVo.TransferVO;
import vo.LogVo.LogVO;
import vo.ManageVo.InstitutionVO;
import businessLogic.logBL.LogBL;
import businessLogicService.intermediateBLService.TransferBLService;

public class TransferController implements TransferBLService {
	TransferBL transferBL;
	LogBL logBL;
	
	public TransferController() throws RemoteException {
		transferBL = new TransferBL();
		logBL =new LogBL();
	}

	public String add(TransferVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增中转单"));
		return transferBL.add(vo);
	}

	public String delete(TransferVO vo) throws RemoteException {
		return transferBL.delete(vo);
	}

	public List<String> getList(String transferID) throws RemoteException {
		return transferBL.getList(transferID);
	}

	public List<String> getCities() throws RemoteException {
		return transferBL.getCities();
	}

	public List<InstitutionVO> getInstitutionList(String userID)
			throws RemoteException {
		return transferBL.getInstituitonList(userID);
	}

	public InstitutionVO getCurrentInstitution(String userID)
			throws RemoteException {
		return transferBL.getCurrentInstitution(userID);
	}

}
