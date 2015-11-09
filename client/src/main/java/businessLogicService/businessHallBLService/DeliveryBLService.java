package businessLogicService.businessHallBLService;

import vo.DeliveryVO;

/**
 * 
 * 派件单的相关操作的业务逻辑实现接口
 *
 */
public interface DeliveryBLService {
	public void add(String id);
	
	public void end();
	
	/**
	 * 提交派件单操作
	 * @param vo 传入一个派件单的vo对象
	 * @return 派件单是否建立成功
	 */
	public boolean submit(DeliveryVO vo);
}
