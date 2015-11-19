package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.IncomePO;

public interface IncomeDataService extends Remote{
	
	
	
	public void add(IncomePO po)throws RemoteException;
	
	public void delete()throws RemoteException;
	
	public List<IncomePO> getIncomeList()throws RemoteException;
	
	

}
