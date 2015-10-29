package businessLogicsService;

import vo.InstitutionVO;
import vo.UserVO;

public interface ManageBLService {
	public UserVO getUser();

	public boolean updateUser(UserVO vo);

	public InstitutionVO getInst();

	public boolean updateInst(InstitutionVO vo);
}
