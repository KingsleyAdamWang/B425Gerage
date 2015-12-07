package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.EntryPO;

public interface EntryDataService extends Remote{
	
	
	public void add(EntryPO po)throws RemoteException;
	
	public void delete(EntryPO po)throws RemoteException;
	
	public EntryPO find(String id)throws RemoteException;
	
	public void modify(EntryPO po)throws RemoteException;
	
	public void approval(EntryPO po)throws RemoteException;
	
	public void approvalAll()throws RemoteException;
	
	public  List<EntryPO> getEntryList() throws RemoteException;
	
	public List<EntryPO> getEntryList(String institutionID)throws RemoteException;


}
