package businessLogicsService;

import vo.EntruckVO;

/**
 * 
 * 装车单操作的业务逻辑接口
 *
 */
public interface EntruckBLService {
	public void add(String id);

	public void end();

	/**
	 * 装车单提交
	 * @param vo
	 * @return
	 */
	public boolean submit(EntruckVO vo);
}
