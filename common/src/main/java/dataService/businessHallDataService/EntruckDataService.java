package dataService.businessHallDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.businessPO.EntruckPO;

/**
 * 装车单的对应的数据层的接口
 * @author 王栋
 *
 */
public interface EntruckDataService extends Remote{
	/**
	 * 数据中增加一个装车单PO
	 * @param po EntruckPO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void add(EntruckPO po)throws RemoteException;
	
	/**
	 * 数据中删除某个装车单的PO
	 * @param po EntruckPO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void delete(EntruckPO po)throws RemoteException;
	
	/**
	 * 根据装车单的编号查找某一张装车单
	 * @param id 撞车单编号
	 * @return 返回的是符合该编号的EntruckPO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public EntruckPO find(String id)throws RemoteException;

	/**
	 * 修改某张装车单的相关信息(总经理)
	 * @param poEntruckPO
	 * @throws RemoteException远程异常 RMI提供
	 */
    public void modify(EntruckPO po)throws RemoteException;

    /**
     * 审批通过某一张装车单
     * @param poEntruckPO
     * @throws RemoteException远程异常 RMI提供
     */
    public void approval(EntruckPO po)throws RemoteException;
    /**
     * 总经理一键审批装车单
     * @throws RemoteException远程异常 RMI提供
     */
    public void approvalAll() throws RemoteException;
    /**
     * 获得撞车的数据List
     * @return 返回一个装车单PO的List
     * @throws RemoteException远程异常 RMI提供
     */
    public List<EntruckPO> getEntruckList() throws RemoteException;
    
}
