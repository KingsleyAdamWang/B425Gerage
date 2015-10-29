package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ConditionPO;
import po.ExportPO;

public interface FormDataService extends Remote{
	public ConditionPO checkCondition()throws RemoteException;
	
	public void export(ExportPO po)throws RemoteException;
}
