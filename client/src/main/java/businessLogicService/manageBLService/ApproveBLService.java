package businessLogicService.manageBLService;

import java.util.List;
import vo.DocumentVO;

/**
 * 
 * 实现总经理审批各类单据的业务逻辑接口
 *
 */
public interface ApproveBLService {
	public List<DocumentVO> getApproveList();
	
	public boolean passDocument(String id);
	
	public boolean updateDoccument(DocumentVO vo);
	
	public boolean pass(DocumentVO vo);
	
	public boolean fail(DocumentVO vo);
}
