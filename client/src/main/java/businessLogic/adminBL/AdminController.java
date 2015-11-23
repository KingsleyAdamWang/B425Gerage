package businessLogic.adminBL;

import java.util.List;

import vo.InstitutionVO;
import vo.UserVO;
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
	public List<UserVO> search(String key) {

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
	public List<UserVO> getUserListByInsID(String institutionID) {

		return adminBL.getUserListByInsID(institutionID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see businessLogicService.adminBLService.AdminBLService#getInsList()
	 */
	public List<InstitutionVO> getInsList() {

		return adminBL.getInsList();
	}

}
