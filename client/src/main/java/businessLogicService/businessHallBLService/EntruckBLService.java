package businessLogicService.businessHallBLService;

import java.rmi.RemoteException;

import vo.EntruckVO;

/**
 * 
 * 装车单操作的业务逻辑接口
 *
 */
public interface EntruckBLService {
	public String add(EntruckVO eVO) throws RemoteException;

	public  EntruckVO search(String id) throws RemoteException;

	/**
	 * 装车单提交
	 * @param vo
	 * @return
	 */
	public String submit(EntruckVO eVO);
	
	public String delete(EntruckVO eVO) throws RemoteException;
}
