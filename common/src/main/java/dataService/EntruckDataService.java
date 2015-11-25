package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.EntruckPO;

public interface EntruckDataService extends Remote{
	public void add(EntruckPO po)throws RemoteException;
	
	public void delete(EntruckPO po)throws RemoteException;
	
	public EntruckPO find(String id)throws RemoteException;

    public void modify(EntruckPO po)throws RemoteException;

    public void approval(EntruckPO po)throws RemoteException;
    
    public void approvalAll() throws RemoteException;
    
    public List<EntruckPO> getEntruckList() throws RemoteException;
    
}
