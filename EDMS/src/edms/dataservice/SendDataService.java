package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.SendPO;

public interface SendDataService {
	public void add(SendPO po)throws RemoteException;
	
	public void delete(SendPO po)throws RemoteException;
	
	public SendPO find(String id)throws RemoteException;
	
}
