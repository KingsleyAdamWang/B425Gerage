package businessLogicService.manageBLService;

import vo.UserVO;

public interface StaffBLService {
	public UserVO getUser(String id);
	
	public String addUser(String id,UserVO vo);
	
	public String updateUser(String id, UserVO vo);
	
	public String deleteUser(String id);
}
