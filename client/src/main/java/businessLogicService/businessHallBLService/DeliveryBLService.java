package businessLogicService.businessHallBLService;

import java.rmi.RemoteException;

import vo.BussinessHallVo.DeliveryVO;
import vo.DeliverymanVo.SendVO;

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
	public String add(DeliveryVO dVO) throws RemoteException;
	
	public DeliveryVO search(String id) throws RemoteException;
	
	public String delete(DeliveryVO dVO) throws RemoteException;
	
	public SendVO getSendMessage(String id) throws RemoteException;
	/**
	 * 提交派件单操作
	 * @param vo 传入一个派件单的vo对象
	 * @return 派件单是否建立成功
	 */
	public String submit(DeliveryVO dVO) ;
	
}
