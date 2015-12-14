package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;
/**
 * 用户的数据层接口类
 * @author 王栋
 *
 */
public interface UserDataService extends Remote {
	
	/**
	 * 根据身份ID 查找该对象
	 * @param identityID
	 * @return
	 * @throws RemoteException
	 */
	public UserPO find(String identityID) throws RemoteException;

	/**
	 * 初始化
	 * @return
	 * @throws RemoteException
	 */
	public boolean init() throws RemoteException;

	/**
	 * 增加一个userpo (总经理)
	 * @param po
	 * @throws RemoteException
	 */
	public void add(UserPO po) throws RemoteException;

	/**
	 * 删除该员工
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(UserPO po) throws RemoteException;

//	public void update(UserPO po) throws RemoteException;
	/**
	 * 修改该员工的一些信息然后储存（总经理和管理员）
	 * @param po
	 * @param password
	 * @throws RemoteException
	 */
	public void modify(UserPO po,String password) throws RemoteException;
	
	/**
	 * 获得所有的userPO的list
	 * @return
	 * @throws RemoteException
	 */
	public List<UserPO> getUsers() throws RemoteException;


}
