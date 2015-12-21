package dataService.businessHallDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
/**
 * 到达单的data层接口
 * @author 王栋
 * 
 */
public interface ArrivalDataService extends Remote{
	
	/**
	 * 增加一个到达单数据PO
	 * @param po到达单PO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void add(ArrivalPO po)throws RemoteException;
	
	/**
	 * 删除一个到达单PO
	 * @param po 到达单PO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void delete(ArrivalPO po)throws RemoteException;
	/**
	 * 修改到达单中的数据(总经理)
	 * @param po到达单PO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void modify(ArrivalPO po)throws RemoteException;
	/**
	 * 审批通过某一个到达单（总经理）
	 * @param po想要审批通过的到达单PO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void approval(ArrivalPO po)throws RemoteException;
	/**
	 * 一键审批全通过（总经理）
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void approvalAll()throws RemoteException;
	/**
	 * 获得一个arrivalPO的集合 包含所有的arrivalPO的数据
	 * @return 所有的ArrivalPO的一个list
	 * @throws RemoteException远程异常 RMI提供
	 */
	public List<ArrivalPO> getArrivalList()throws RemoteException;
}
