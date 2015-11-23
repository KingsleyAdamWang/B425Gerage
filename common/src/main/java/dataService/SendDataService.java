package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.SendPO;

public interface SendDataService extends Remote{
	
	//增加一个 寄件单 的数据
	public void add(SendPO po)throws RemoteException;
	
	//删除一个寄件单的数据
	public void delete(SendPO po)throws RemoteException;


	public List<SendPO> getSendList()throws RemoteException;
	
    public void modify(SendPO po)throws RemoteException;	
    
    public void agree(String id)throws RemoteException;

}
