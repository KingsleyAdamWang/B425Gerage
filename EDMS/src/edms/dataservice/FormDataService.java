package edms.dataservice;

import java.rmi.RemoteException;

import edms.po.ConditionPO;
import edms.po.ExportPO;

public interface FormDataService {
	public ConditionPO checkCondition()throws RemoteException;
	
	public void export(ExportPO po)throws RemoteException;
}
