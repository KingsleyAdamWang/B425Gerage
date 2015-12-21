package dataService.logDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.LogPO;

/**
 * log日志的数据层接口
 * @author 王栋
 *
 */
public interface LogDataService extends Remote {

	public  void add(LogPO po) throws RemoteException;

	
	public void clear() throws RemoteException;
	
	public List<LogPO> getLogList()throws RemoteException;
}
