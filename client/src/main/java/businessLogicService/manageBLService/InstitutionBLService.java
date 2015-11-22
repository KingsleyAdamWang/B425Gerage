package businessLogicService.manageBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.InstitutionVO;

public interface InstitutionBLService {
	public List<InstitutionVO> show();

	public String addIns(InstitutionVO insVO) throws RemoteException;
	
	public String deleteIns(InstitutionVO insVO) throws RemoteException;
	
	public String modify(String id,String newName) throws RemoteException;
	
	public InstitutionVO search(String id);
}
