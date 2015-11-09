package businessLogicService.manageBLService;

import vo.DocumentVO;

/**
 * 
 * 实现总经理审批各类单据的业务逻辑接口
 *
 */
public interface ApproveBLService {
	public void approve();
	
	public boolean pass(DocumentVO vo);
	
	public boolean fail(DocumentVO vo);
}
