package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ApprovePO;

public interface ApproveDataService extends Remote{
	public void update(ApprovePO po)throws RemoteException;

}
