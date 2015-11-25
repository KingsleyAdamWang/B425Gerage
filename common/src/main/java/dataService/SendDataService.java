package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.SendPO;

public interface SendDataService extends Remote {

	// 增加一个 寄件单 的数据
	public void add(SendPO po) throws RemoteException;

	// 删除一个寄件单的数据
	public void delete(SendPO po) throws RemoteException;

	// 返回所有的SendPO的数据列表
	public List<SendPO> getSendList() throws RemoteException;

	// 修改某一个寄件单的内容
	public void modify(SendPO po) throws RemoteException;

	// 审批通过 某一个寄件单 通过条形码号来进行修改
	public void approval(SendPO po) throws RemoteException;

	public void approvalAll() throws RemoteException;
}
