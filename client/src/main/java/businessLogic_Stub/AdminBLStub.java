package businessLogic_Stub;

import java.rmi.RemoteException;
import java.util.List;

import vo.InstitutionVO;
import vo.UserVO;
import businessLogicService.adminBLService.AdminBLService;

public class AdminBLStub implements AdminBLService {


	public void add(String message) {
		// TODO Auto-generated method stub

	}


	public void delete(String message) {
		// TODO Auto-generated method stub

	}


	public void update(String message) {
		// TODO Auto-generated method stub

	}


	public List<UserVO> search(String Key) {
		// TODO Auto-generated method stub
		return null;
	}


	public String modify(String identityID, String newPassWord)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public List<UserVO> getUserListByInsID(String institutionID) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<InstitutionVO> getInsList() {
		// TODO Auto-generated method stub
		return null;
	}

}
