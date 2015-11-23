package businessLogic.adminBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.InstitutionPO;
import po.UserPO;
import vo.InstitutionVO;
import vo.UserVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.InstitutionDataService;
import dataService.UserDataService;

public class AdminBL {

	private UserDataService UserDS;
	/*
	 * 存所有的user的list
	 */
	private List<UserPO> userList;

	/**
	 * 暂存复合条件的某些list
	 */
	private List<UserPO> tempList;

	public AdminBL() {
		try {
			RMIHelper.initUserDataService();
			UserDS = RMIHelper.getUserDataService();
			userList = UserDS.getUsers();
			System.out.println(userList.size());
			tempList = new ArrayList<UserPO>();

		} catch (ClientInitException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 关键字查询用户
	 */
	public List<UserVO> search(String key) {

		tempList.clear();
		
		for (UserPO po : userList) {
			if (po.getIdentityID().contains(key)
					|| po.getInstitutionID().contains(key)
					|| po.getWork().getPositionString().contains(key)
					|| po.getName().contains(key)){
				tempList.add(po);}
		}
		// tempList = result;
		return transToVOList(tempList);
	}

	private List<UserVO> transToVOList(List<UserPO> temp) {
		List<UserVO> voList = new ArrayList<UserVO>(temp.size());
        for(UserPO po: temp)
        	voList.add(new UserVO(po));
        return  voList;
	}

	/**
	 * 根据机构选择人员
	 */
	public List<UserVO> getUserListByInsID(String institutionID) {
		tempList.clear();
		for (UserPO po : userList) {
			if (po.getInstitutionID().equals(institutionID))
				tempList.add(po);
		}
		return transToVOList(tempList);
	}

	/*
	 * 获取机构列表
	 */
	public List<InstitutionVO> getInsList() {
		InstitutionDataService insDS;
		List<InstitutionPO> insList = new ArrayList<InstitutionPO>();
		try {
			RMIHelper.initInstitutionDataService();
			insDS = RMIHelper.getInstitutionDataService();
			insList = insDS.getInsList();
			tempList = new ArrayList<UserPO>();

		} catch (ClientInitException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<InstitutionVO> result = new ArrayList<InstitutionVO>(insList.size());
		for(InstitutionPO po : insList)
			result.add(new InstitutionVO(po));
		return result;
	}

	/**
	 * 修改某个账户的密码
	 * 
	 * @param identityID
	 * @param newPassWord
	 * @return
	 */
	public String modify(String identityID, String newPassWord) {
		if (newPassWord.length() > 16 || newPassWord.length() < 6)
			return "密码应该6-16，重新设置！";
		else {
			for (UserPO po : tempList)
				if (po.getIdentityID().equals(identityID)) {
					userList.get(userList.indexOf(po)).setPassword(newPassWord);
					try {
						UserDS.modify(po, newPassWord);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return null;
				}
			return "未找到该用户";
		}

	}

}
