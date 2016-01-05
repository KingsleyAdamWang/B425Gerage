package businessLogic.loginBL;

import java.util.ArrayList;
import java.util.List;

import po.adminPO.UserPO;
import enumSet.Position;

public class StubLoginBL {
	List<UserPO> userList;
	
	public void StubLoginBL(){
		userList=new ArrayList<UserPO>();
		userList.add(new UserPO("员工一", "123456", "00000001", "000001", Position.JOB_1));
		userList.add(new UserPO("员工二", "123456", "00000002", "000001", Position.JOB_2));
		userList.add(new UserPO("员工三", "123456", "000003", "0002", Position.JOB_3));
		userList.add(new UserPO("员工四", "123456", "000004", "0002", Position.JOB_4));
		userList.add(new UserPO("员工五", "123456", "000005", "0003", Position.JOB_5));
		userList.add(new UserPO("总经理", "123456", "000006", "0000", Position.JOB_7));
	}
	
	public List<UserPO> getUserPOList(){
		return userList;
	}
}
