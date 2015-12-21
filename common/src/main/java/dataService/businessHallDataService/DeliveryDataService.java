package dataService.businessHallDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
/**
 * 派件单数据层接口
 * @author 王栋
 *
 */
public interface DeliveryDataService extends Remote{
	/**
	 * 增加一张派件单
	 * @param po
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void add(DeliveryPO po) throws RemoteException;

	/**
	 * 删除一张派件单
	 * @param po远程异常 RMI提供
	 * @throws RemoteException
	 */
	public void delete(DeliveryPO po) throws RemoteException;
	
	/**
	 * 修改一张派件单的内容（总经理）
	 * @param po
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void modify(DeliveryPO po) throws RemoteException;
	
	/**
	 * 审批通过某一张派件单(总经理)
	 * @param po
	 * @throws RemoteException远程异常 RMI提供
	 */
    public void approve(DeliveryPO po)throws RemoteException;
    
    /**
     * 总经理选择一键审批
     * @throws RemoteException远程异常 RMI提供
     */
    public void approveAll()throws RemoteException;
    
    /**
     * 获得派件单的所有PO的一个集合
     * @return 派件单po的List
     * @throws RemoteException远程异常 RMI提供
     */
    public List<DeliveryPO> getList()throws RemoteException;
    
    /**
     * 根据快递的十位数编号进行查找其对应的派件单PO
     * @param id 十位数的快递单号
     * @return 对应的DeliveryPO 如果没有返回NULL
     * @throws RemoteException远程异常 RMI提供
     */
	public DeliveryPO find(String id) throws RemoteException;
}
