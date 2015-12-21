package dataService.manageDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.managePO.SalaryPO;

/**
 * 制定工资常量的数据层接口类
 * @author 王栋
 *
 */
public interface SalaryDataService extends Remote{
	
	
	public  SalaryPO getSalaryPO()throws RemoteException;
	
	public void modify(SalaryPO po)throws RemoteException;
}
