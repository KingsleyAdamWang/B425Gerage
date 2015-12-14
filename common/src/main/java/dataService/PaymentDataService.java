package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.PaymentPO;

public interface PaymentDataService extends Remote{

	public void add(PaymentPO po)throws RemoteException;
	
	public void delete(PaymentPO po)throws RemoteException;
	
	public void modify(PaymentPO po)throws RemoteException;
	
	public List<PaymentPO> find(Date d)throws RemoteException;
	
	public List<PaymentPO> getList()throws RemoteException;
	
	public void approval(PaymentPO po)throws RemoteException;
	
	public void approvalAll()throws RemoteException;
	
	}
