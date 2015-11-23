package businessLogic.deliveryBL;

import java.rmi.RemoteException;
import java.util.List;

import po.SendPO;
import vo.SendVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.SendDataService;

public class SendBL {
	SendDataService sendDS;
	List<SendPO> sendList;
	
	public  SendBL() throws RemoteException {
		try {
			RMIHelper.initSendDataService();
			sendDS = RMIHelper.getSendDataService();
//			sendList=sendDS.();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public String add(SendVO vo) throws RemoteException{
		SendPO po=vo.transToPO();
		for(SendPO temp : sendList){
			if(temp.getId().equals(po.getId()))
				return "存在相同编号的快递单";
		}
		sendList.add(po);
		sendDS.add(po);
		
		return null;
	}
	
	public String delete(SendVO vo) throws RemoteException{
		SendPO po=vo.transToPO();
		for(SendPO temp: sendList){
			if(temp.getId().equals(vo.getId())){
				sendList.remove(temp);
				sendDS.delete(temp);
				return null; 
			}
		}
		
		return "未找到对应快递单";
	}
	
	
	
}
