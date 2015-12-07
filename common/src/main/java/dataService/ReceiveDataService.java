package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ReceivePO;

public interface ReceiveDataService extends Remote {
	public void add(ReceivePO po) throws RemoteException;

	public void delete(ReceivePO po) throws RemoteException;

	public void modify(ReceivePO po) throws RemoteException;

	public ReceivePO find(String id) throws RemoteException;

	public void approve(ReceivePO po) throws RemoteException;

	public void approveAll() throws RemoteException;

	public List<ReceivePO> getList() throws RemoteException;

}
