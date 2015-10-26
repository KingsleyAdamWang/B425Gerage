package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.TransferPO;

public interface TransferDataService {
	public void add(TransferPO po)throws RemoteException;
	
	public void delete(TransferPO po)throws RemoteException;
	
	public TransferPO find(String id)throws RemoteException;
}
