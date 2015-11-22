package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.List;

import vo.UserVO;
import businessLogicService.manageBLService.StaffBLService;

public class StaffController implements StaffBLService {
	StaffBL staffBL;
	
	public StaffController() throws RemoteException{
		staffBL= new StaffBL();
	}

	public UserVO getUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return staffBL.getUser(id);
	}

	public String addUser(String id, UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return staffBL.addUser(id, vo);
	}

	public String updateUser(String id, UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return staffBL.updateUser(id, vo);
	}

	public String deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return staffBL.delete(id);
	}
	
	public List<UserVO> getUsers(){
		return staffBL.getUsers();
	}
	
	public List<UserVO> getUsersOfIns(String InstitutionID) throws RemoteException{
		return staffBL.getUsersOfIns(InstitutionID);
	}

}
