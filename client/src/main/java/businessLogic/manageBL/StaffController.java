package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.AdminVo.UserVO;
import vo.LogVo.LogVO;
import businessLogic.logBL.LogBL;
import businessLogicService.manageBLService.StaffBLService;

public class StaffController implements StaffBLService {
	private StaffBL staffBL;
	private LogBL logBL;
	
	public StaffController() throws RemoteException{
		staffBL= new StaffBL();
		logBL=new LogBL();
	}

	public UserVO getUser(String userID) throws RemoteException {
		
		return staffBL.getUser(userID);
	}

	public String addUser(String userID, UserVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增人员信息"));
		return staffBL.addUser(userID, vo);
	}

	public String updateUser(String userID, UserVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"修改人员信息"));
		return staffBL.updateUser(userID, vo);
	}

	public String deleteUser(String userID) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除人员信息"));
		return staffBL.delete(userID);
	}
	
	public List<UserVO> getUsers(){
		
		return staffBL.getUsers();
	}
	
	public List<UserVO> getUsersOfIns(String InstitutionID) throws RemoteException{
		return staffBL.getUsersOfIns(InstitutionID);
	}

}
