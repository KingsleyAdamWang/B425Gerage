package businessLogicService.businessHallBLService;

import java.rmi.RemoteException;

import vo.BussinessHallVo.ArrivalVO;
import client.ClientInitException;

/**
 * 
 * 实现到达单操作的业务逻辑接口
 *
 */
public interface ArrivalBLService {
	
	public String add(ArrivalVO arrivalVO) throws RemoteException, ClientInitException;

	public ArrivalVO search(String id) throws RemoteException;

	public String delete(ArrivalVO arrivalVO) throws RemoteException ;
	
	public String modify(ArrivalVO arrivalVO) throws RemoteException;
	
	public String getInstitutionName() throws RemoteException;
}
