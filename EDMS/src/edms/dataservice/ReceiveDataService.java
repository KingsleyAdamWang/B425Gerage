package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.ReceivePO;

public interface ReceiveDataService {
	public void add(ReceivePO po)throws RemoteException;
	
	public void delete(ReceivePO po)throws RemoteException;
	
	public ReceivePO find(String id)throws RemoteException;
}
