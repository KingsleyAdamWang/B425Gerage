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

	public UserVO getUser(String userID) throws RemoteException {

		return staffBL.getUser(userID);
	}

	public String addUser(String institutionID, UserVO vo) throws RemoteException {

		return staffBL.addUser(institutionID, vo);
	}

	public String updateUser(String userID, UserVO vo) throws RemoteException {
		
		return staffBL.updateUser(userID, vo);
	}

	public String deleteUser(String userID) throws RemoteException {
		
		return staffBL.delete(userID);
	}
	
	public List<UserVO> getUsers(){
		
		return staffBL.getUsers();
	}
	
	public List<UserVO> getUsersOfIns(String InstitutionID) throws RemoteException{
		return staffBL.getUsersOfIns(InstitutionID);
	}

}
