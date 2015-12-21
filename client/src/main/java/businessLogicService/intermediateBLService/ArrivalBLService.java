package businessLogicService.intermediateBLService;

import vo.BussinessHallVo.ArrivalVO;

/**
 * 
 * 实现到达单操作的业务逻辑接口
 *
 */
public interface ArrivalBLService {
	
	public void add(String id);

	public void end();

	/**
	 * 提交到达单
	 * @param vo 一个到达单vo对象 
	 * @return 该到达单是否成功建立
	 */
	public boolean submit(ArrivalVO vo);
	
}
