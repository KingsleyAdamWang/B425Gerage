package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PriceConstPO;

public interface PriceConstDataService extends Remote{

	
	public void update(PriceConstPO po)throws RemoteException;
	
	public PriceConstPO getPriceConst()throws RemoteException;
}
