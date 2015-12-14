package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ReceivePO;

/**
 * 收件单的数据层的接口 接口的信息注释省略（同其他单据）
 * @author 王栋
 *
 */
public interface ReceiveDataService extends Remote {
	public void add(ReceivePO po) throws RemoteException;

	public void delete(ReceivePO po) throws RemoteException;

	public void modify(ReceivePO po) throws RemoteException;

	public ReceivePO find(String id) throws RemoteException;

	public void approve(ReceivePO po) throws RemoteException;

	public void approveAll() throws RemoteException;

	public List<ReceivePO> getList() throws RemoteException;

}
