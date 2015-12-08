package businessLogic.deliveryBL;

import java.rmi.RemoteException;
import java.util.List;

import po.ReceivePO;
import vo.ReceiveVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.ReceiveDataService;

public class ReceiveBL {
	private ReceiveDataService receiveDS;
	private List<ReceivePO> receiveList; 
	private ReceivePO receivePO;
	
	public ReceiveBL() throws RemoteException {
		try {
			RMIHelper.initReceiveDataService();
			receiveDS = RMIHelper.getReceiveDataService();
			receiveList = receiveDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public String add(ReceiveVO vo) throws RemoteException{
		receivePO=vo.transToPO();
		for(ReceivePO temp: receiveList){
			if(temp.equals(receivePO)){
				return "存在相同收件单";
			}
		}
		
		receiveList.add(receivePO);
		receiveDS.add(receivePO);
		return null;
	}
	
	public String delete(ReceiveVO vo) throws RemoteException{
		receivePO=vo.transToPO();
		for(ReceivePO temp: receiveList){
			if(temp.equals(receivePO)){
				receiveList.remove(temp);
				receiveDS.delete(receivePO);
				return null;
			}
		}
		
		return "未找到收件单";
	}
	
	public String modify(ReceiveVO vo) throws RemoteException{
		receivePO=vo.transToPO();
		for(ReceivePO temp: receiveList){
			if(temp.equals(receivePO)){
				receiveList.remove(temp);
				receiveList.add(receiveList.indexOf(temp),receivePO);
				receiveDS.modify(receivePO);
			}
		}
		return "未找到对应收件单";
	}
}
