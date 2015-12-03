package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.TransferPO;

public interface TransferDataService extends Remote{
	public void add(TransferPO po)throws RemoteException;
	
	public void delete(TransferPO po)throws RemoteException;
	
    public List<TransferPO> getList()throws RemoteException;
	
    
    public void modify(TransferPO po)throws RemoteException;
	public void approve(TransferPO po) throws RemoteException;
    
    public void approveAll()throws RemoteException;
	
	public TransferPO find(String id)throws RemoteException;
}
