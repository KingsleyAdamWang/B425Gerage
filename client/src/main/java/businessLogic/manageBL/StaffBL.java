package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import dataService.UserDataService;
import enumSet.Position;
import po.UserPO;
import util.CheckUtil;
import vo.UserVO;

public class StaffBL {
	
	private UserDataService userDS;
	private List<UserPO> users;
	
	public  StaffBL() throws RemoteException {
		try {
			RMIHelper.initUserDataService();
			userDS = RMIHelper.getUserDataService();
			users = userDS.getUsers();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public UserVO getUser(String id) throws RemoteException{	
		UserPO po=this.userDS.find(id);
		return new UserVO(po);
	}
	
	public List<UserVO> getUsers(){
		List<UserVO> users = new ArrayList<UserVO>();
		//按照职位排列返回user列表
		for(Position tempPos: Position.values()){
			for(UserPO temp : this.users){
				if(temp.getWork()==tempPos){
					users.add(new UserVO(temp));
				}
			}
		}
//		for(UserPO temp : this.users){
//			users.add(new UserVO(temp));
//		}
		return users;
	}
	
	public List<UserVO> getUsersOfIns(String InstitutionID) throws RemoteException{
		List<UserVO> users = new ArrayList<UserVO>();
		for(UserPO temp : this.users){
			if(temp.getInstitutionID().equals(InstitutionID)){
				users.add(new UserVO(temp));
			}
		}
		return users;
	}
	
	public String addUser(String id,UserVO vo) throws RemoteException{
		UserPO po=vo.transToPO();
		if(!CheckUtil.checkStaffID(id,vo.getInstitutionID())){
			return "编号格式不符合规范";
		}
		for(UserPO temp : users){
			if(temp.getIdentityID().equals(id)){
				return "存在相同ID，添加失败";
			}	
		}
	
		users.add(po);
		userDS.add(po);
		
		
		return null;
	}
	
	public String updateUser(String id,UserVO vo) throws RemoteException{
		UserPO po=vo.transToPO();
		for(UserPO temp : users){
			if(temp.getIdentityID().equals(id)){
				
				//删除原有PO ，新增PO
				users.remove(temp);
				userDS.delete(temp);
				
				users.add(po);
				userDS.add(po);
				return null;
			}
		}
		return "未找到对应PO";
	}
	
	public String delete(String id) throws RemoteException{
		for(UserPO temp :users){
			if(temp.getIdentityID().equals(id)){
				if(temp.getWork()==Position.JOB_7||temp.getWork()==Position.JOB_8){
					//如果是总经理或管理员，无法删除
					return "该人员无法删除";
				}
				userDS.delete(temp);
				users.remove(temp);
				return null;
			}
		}
		
		return "未找到对应PO";
	}
	
}
