package dataService.inventoryDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.EntryPO;

public interface EntryDataService extends Remote{
	
	/**
	 * 增加一张入库单
	 * @param po 增的EntryPO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void add(EntryPO po)throws RemoteException;
	
	/**
	 * 删除一张入库单
	 * @param po 删除的EntryPO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void delete(EntryPO po)throws RemoteException;
	
	/**
	 * 查找某张的入库单
	 * @param id快递的账号
	 * @return
	 * @throws RemoteException
	 */
	public EntryPO find(String id)throws RemoteException;
	
	/**
	 * 修改入库单
	 * @param po
	 * @throws RemoteException Rmi产生的远程调用异常
	 */
	public void modify(EntryPO po)throws RemoteException;
	
	/**
	 * 总i节能管理审批通过某一份入库单
	 * @param po
	 * @throws RemoteException Rmi产生的远程调用异常
	 */
	public void approval(EntryPO po)throws RemoteException;
	
	/**
	 * 总经理一键审批
	 * @throws RemoteException Rmi产生的远程调用异常
	 */
	public void approvalAll()throws RemoteException;
	
	/**
	 * 获得入库单 所有
	 * @return EntryList
	 * @throws RemoteException Rmi产生的远程调用异常
	 */
	public  List<EntryPO> getEntryList() throws RemoteException;
	
	/**
	 * 获得某一个机构的入库单
	 * @param institutionID
	 * @return
	 * @throws RemoteException
	 */
	public List<EntryPO> getEntryList(String institutionID)throws RemoteException;

}



