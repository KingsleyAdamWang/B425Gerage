package businessLogicService.intermediateBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.IntermediateVo.TransferVO;

public interface TransferBLService {
	public  String add(TransferVO vo) throws RemoteException;

	public String delete(TransferVO vo) throws RemoteException;

	public List<String> getList(String transferID) throws RemoteException;
	
	public List<String> getCities() throws RemoteException;
	
}
