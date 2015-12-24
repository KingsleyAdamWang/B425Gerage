package businessLogic.intermediateBL;

import java.rmi.RemoteException;
import java.util.List;

import vo.IntermediateVo.TransferVO;
import vo.ManageVo.InstitutionVO;
import businessLogicService.intermediateBLService.TransferBLService;

public class TransferController implements TransferBLService{
	TransferBL transferBL;
	
	public TransferController() throws RemoteException{
		transferBL=new TransferBL();
	}
	public String add(TransferVO vo) throws RemoteException{
		return transferBL.add(vo);
	}

	public String delete(TransferVO vo) throws RemoteException{
		return transferBL.delete(vo);
	}

	public List<String> getList(String transferID) throws RemoteException{
		return transferBL.getList(transferID);
	}
	
	public List<String> getCities() throws RemoteException{
		return transferBL.getCities();
	}
	
	public List<InstitutionVO> getInstitutionList(String userID) throws RemoteException{
		return transferBL.getInstituitonList(userID);
	}

}
