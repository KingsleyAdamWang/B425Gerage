package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.IncomePO;

public interface MoneyDataService {
	public void addPayment();
	
	public IncomePO check()throws RemoteException;
}
