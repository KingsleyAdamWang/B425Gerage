package businessLogicService.businessHallBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.CashRegisterVO;

/**
 * 
 * 实现收款单的业务逻辑接口
 *
 */
public interface CashRegisterBLService {
	public String add(CashRegisterVO crVO) throws RemoteException;

	public String search(String id);

	public String delete(CashRegisterVO crVO); 

	/**
	 * 提交收款单
	 * @param vo 收款的一个vo对象
	 * @return 新建收款的成功与否状态
	 */
	public String submit(CashRegisterVO vo);
	
	/**
	 * 根据传入的一个收款单的Vo表单 进行收款的总和计算
	 * 
	 * @param lists
	 * @return 符合条件的相关收款总金额
	 */
	public double total(List<CashRegisterVO> lists);

}
