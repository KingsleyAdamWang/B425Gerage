package businessLogic.adminBL;

import java.rmi.RemoteException;

import javax.swing.text.Position;

import po.InstitutionPO;
import po.UserPO;

import java.rmi.RemoteException;
import java.util.List;

import businessLogicService.adminBLService.AdminBLService;

/**
 * 
 * @author 王栋
 *
 */
public class AdminController implements AdminBLService {

	AdminBL adminBL;

	public AdminController() {
		adminBL = new AdminBL();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businessLogicService.adminBLService.AdminBLService#search(java.lang.String
	 * )
	 */
	public List<UserPO> search(String key) {

		return adminBL.search(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businessLogicService.adminBLService.AdminBLService#modify(java.lang.String
	 * , java.lang.String)
	 */
	public String modify(String identityID, String newPassWord) {
		return adminBL.modify(identityID, newPassWord);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businessLogicService.adminBLService.AdminBLService#getUserListByInsID
	 * (java.lang.String)
	 */
	public List<UserPO> getUserListByInsID(String institutionID) {

		return adminBL.getUserListByInsID(institutionID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see businessLogicService.adminBLService.AdminBLService#getInsList()
	 */
	public List<InstitutionPO> getInsList() {

		return adminBL.getInsList();
	}

}
