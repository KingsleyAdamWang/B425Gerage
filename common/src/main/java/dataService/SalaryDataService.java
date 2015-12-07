package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.SalaryPO;

public interface SalaryDataService extends Remote{
	
	
	public  SalaryPO getSalaryPO()throws RemoteException;
	
	public void modify(SalaryPO po)throws RemoteException;
}
