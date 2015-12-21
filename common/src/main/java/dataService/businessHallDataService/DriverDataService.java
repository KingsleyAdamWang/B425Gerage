package dataService.businessHallDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DriverPO;

/**
 * 司机信息管理的对应的数据层的接口
 * @author 王栋
 *
 */
public interface DriverDataService extends Remote{
	/**
	 * 增加司机信息 数据中增加一个DriverPO
	 * @param po DriverPO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public void add(DriverPO po)throws RemoteException;
	/**
	 * 删除一个司机的信息
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(DriverPO po)throws RemoteException;
	/**
	 * 根据司机的ID查找一个司机的信息
	 * @param id 司机身份ID
	 * @return 对应查找到的司机PO
	 * @throws RemoteException远程异常 RMI提供
	 */
	public DriverPO find(String id)throws RemoteException;
	
	/**
	 * 修改司机信息
	 * @param po
	 * @throws RemoteException
	 */
	public void Modify(DriverPO po)throws RemoteException;
	
	/**
	 * 返回列表
	 * @return
	 * @throws RemoteException
	 */
	public List<DriverPO> getList()throws RemoteException;
}
