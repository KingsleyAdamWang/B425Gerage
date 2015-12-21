package dataService.inventoryDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.inventoryPO.InventoryPO;

/**
 * 库存管理的数据层接口
 * @author 王栋
 *
 */
public interface InventoryDataService extends Remote {

	/**
	 * 增加一个仓库机构的库存情况
	 * @param po
	 * @throws RemoteException
	 */
	public void add(InventoryPO po) throws RemoteException;

	/**
	 * 修改
	 * @param po
	 * @throws RemoteException
	 */
	public void modify(InventoryPO po) throws RemoteException;
	
	/**
	 * 删除
	 * @param InstitutionID
	 * @throws RemoteException
	 */
	public void delete(String InstitutionID) throws RemoteException;
	
	/**
	 * 返回一个列表
	 * @return
	 * @throws RemoteException
	 */
	public List<InventoryPO> getInventoryList()throws RemoteException;

}
