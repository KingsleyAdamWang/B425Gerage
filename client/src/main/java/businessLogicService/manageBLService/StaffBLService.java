package businessLogicService.manageBLService;

import java.rmi.RemoteException;

import vo.AdminVo.UserVO;

public interface StaffBLService {
	public UserVO getUser(String id) throws RemoteException;
	
	public String addUser(String id,UserVO vo) throws RemoteException;
	
	public String updateUser(String id, UserVO vo) throws RemoteException;
	
	public String deleteUser(String id) throws RemoteException;
}
