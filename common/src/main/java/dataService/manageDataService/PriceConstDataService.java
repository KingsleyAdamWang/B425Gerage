package dataService.manageDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PriceConstPO;

/**
 * 指定距离价格常量的一个数据的数据层接口
 * @author 王栋
 *
 */
public interface PriceConstDataService extends Remote{

	
	public void update(PriceConstPO po)throws RemoteException;
	
	public PriceConstPO getPriceConst()throws RemoteException;
}
