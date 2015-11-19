package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.InstitutionPO;

public interface InstitutionDataService extends Remote{
	
	public void add(InstitutionPO po) throws RemoteException;
	public void delete(String institutionID) throws RemoteException;
	
	public void modify(String id,String name)throws RemoteException;

	public List<InstitutionPO> institutionList() throws RemoteException;
	
	

}
