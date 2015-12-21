package dataService.financeDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.IncomePO;

/**
 * 收款单的相关data层
 * @author 王栋
 *
 */
public interface IncomeDataService extends Remote{
	/**
	 * 增加一个收款单数据到底层
	 * @param po
	 * @throws RemoteException Rmi产生的远程调用异常
	 */
	public void add(IncomePO po)throws RemoteException;
	
	/**
	 * 删除一个收款的数据
	 * @throws RemoteException Rmi产生的远程调用异常
	 */
	public void delete(IncomePO po)throws RemoteException;
	
	/**
	 * 修改
	 * @param po
	 * @throws RemoteException
	 */
	public void modify(IncomePO po)throws RemoteException;
	/**
	 * 审批通过一个
	 * @param po
	 * @throws RemoteException
	 */
	public void approval(IncomePO po)throws RemoteException;
	/**
	 * 一键审批
	 * @throws RemoteException
	 */
	public void apprivalAll()throws RemoteException;
	/**
	 * 获得收款单列表
	 * @return
	 * @throws RemoteException
	 */
	public List<IncomePO> getIncomeList()throws RemoteException;
	/**
	 * 输入时间 返回符合该时间的时间列表
	 * @param d时间参数
	 * @return
	 * @throws RemoteException
	 */
	public List<IncomePO> getListByDate(Date d)throws RemoteException;

}
