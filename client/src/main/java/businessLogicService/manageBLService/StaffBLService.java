package businessLogicService.manageBLService;

import vo.UserVO;

public interface StaffBLService {
	public UserVO getUser(String id);
	
	public boolean addUser(String id,UserVO vo);
	
	public boolean updateUser(String id, UserVO vo);
	
	public boolean deleteUser(String id);
}
