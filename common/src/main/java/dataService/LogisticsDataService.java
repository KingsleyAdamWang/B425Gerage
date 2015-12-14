package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.LogisticsPO;

/**
 * 快递物流信息的数据层接口
 * @author 王栋
 *
 */
public interface LogisticsDataService extends Remote {

//	public void update(String logistics) throws RemoteException;

	public void add(LogisticsPO po) throws RemoteException;

	public boolean modify(String id, String message) throws RemoteException;

	public List<LogisticsPO> getLogisticsList() throws RemoteException;

}
