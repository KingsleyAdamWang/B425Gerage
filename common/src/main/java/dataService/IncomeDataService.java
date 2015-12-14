package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void modify(IncomePO po)throws RemoteException;
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void approval(IncomePO po)throws RemoteException;
	/**
	 * 
	 * @throws RemoteException
	 */
	public void apprivalAll()throws RemoteException;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public List<IncomePO> getIncomeList()throws RemoteException;
	
	

}
