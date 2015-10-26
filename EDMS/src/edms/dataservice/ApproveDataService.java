package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.ApprovePO;

public interface ApproveDataService {
	public void update(ApprovePO po)throws RemoteException;

}
