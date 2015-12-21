package dataService.businessHallDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.TruckPO;

/**
 * 司机信息的数据层接口
 * @author 王栋
 *
 */
public interface TruckDataService extends Remote{
	
	public void add(TruckPO po)throws RemoteException;
	
	public void delete(TruckPO po)throws RemoteException;
	
	public TruckPO find(String id)throws RemoteException;
	
	public void modify(TruckPO po)throws RemoteException;
	
	public List<TruckPO> getList()throws RemoteException;
}
