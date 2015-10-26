package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.AdminPO;

public interface AdminDataService {
	public void add(AdminPO po)throws RemoteException;
	
	public void update(AdminPO po)throws RemoteException;
	
	public AdminPO find(String id)throws RemoteException;
}
