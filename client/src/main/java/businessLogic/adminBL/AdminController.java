package businessLogic.adminBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.logPO.LogPO;
import presentation.MainFrame;
import vo.AdminVo.UserVO;
import vo.ManageVo.InstitutionVO;
import businessLogicService.adminBLService.AdminBLService;
import client.ClientInitException;
import client.RMIHelper;
import dataService.logDataService.LogDataService;

/**
 * 
 * @author 王栋
 *
 */
public class AdminController implements AdminBLService {

	private AdminBL adminBL;
	private LogDataService logDS;

	public AdminController() throws ClientInitException {
		adminBL = new AdminBL();
		RMIHelper.initLogDataService();
		logDS = RMIHelper.getLogDataService();
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
	public String modify(String identityID, String newPassWord)
			throws RemoteException {
		logDS.add(new LogPO(new Date(), MainFrame.getUser().getIdentityID(),
				"人员管理 修改人员"));
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
