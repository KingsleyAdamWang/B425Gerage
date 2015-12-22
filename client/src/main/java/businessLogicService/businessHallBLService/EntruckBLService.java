package businessLogicService.businessHallBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.BussinessHallVo.EntruckVO;

/**
 * 
 * 装车单操作的业务逻辑接口
 *
 */
public interface EntruckBLService {
	public String add(EntruckVO eVO) throws RemoteException;

	public  EntruckVO search(String id) throws RemoteException;
	
	public String delete(EntruckVO eVO) throws RemoteException;
	
	public String modify(EntruckVO eVO) throws RemoteException;
	
	public List<String> getInstitutionNames() throws RemoteException;
	
	public double getDistance(String id,String name);
	
	public double getFare(List<String> sendList) throws RemoteException;
	/**
	 * 装车单提交
	 * @param vo
	 * @return
	 */
	public String submit(EntruckVO eVO);
	
}
