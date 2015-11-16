package businessLogicService.businessHallBLService;

import vo.DeliveryVO;

/**
 * 
 * 派件单的相关操作的业务逻辑实现接口
 *
 */
public interface DeliveryBLService {
	/*
	 * 增加派件单操作
	 * 传入一个VO
	 * 返回String类型的结果告知是否成功
	 * */
	public String add(DeliveryVO dVO);
	
	public DeliveryVO search(String id);
	
	/**
	 * 提交派件单操作
	 * @param vo 传入一个派件单的vo对象
	 * @return 派件单是否建立成功
	 */
	public String submit(DeliveryVO dVO) ;
	
	public String delete(DeliveryVO dVO);
}
