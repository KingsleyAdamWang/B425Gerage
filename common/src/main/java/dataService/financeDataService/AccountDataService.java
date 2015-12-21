package dataService.financeDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.financePO.AccountPO;

/**
 * 银行账户的数据接口层
 * @author 王栋
 *
 */
public interface AccountDataService extends Remote{
	
	/**
	 * 修改账户 只能修改名字
	 * @param po 传入一个账户的po
	 * @param name 账户名字
	 * @return /
	 * @throws RemoteException远程异常 RMI提供
	 */
	public boolean modify(AccountPO po)throws RemoteException;
	
	/**
	 * 增加账户操作
	 * @param po账户PO
	 * @return /
	 * @throws RemoteException远程异常 RMI提供
	 */
	public boolean add(AccountPO po)throws RemoteException;
	
	/**
	 * 删除账户操作
	 * @param po 账户po
	 * @return /
	 * @throws RemoteException远程异常 RMI提供
	 */
	public boolean delete(AccountPO po)throws RemoteException;
	
	/**
	 * 查询账户 根据关键字进行查询
	 * @param key 关键字String Key
	 * @return 一个AccountPO的list
	 * @throws RemoteException远程异常 RMI提供
	 */
	public List<AccountPO> search(String key)throws RemoteException;
	
	public List<AccountPO> getAccounts() throws RemoteException;
	

}
