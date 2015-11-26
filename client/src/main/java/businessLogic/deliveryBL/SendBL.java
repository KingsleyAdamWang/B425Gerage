package businessLogic.deliveryBL;

import java.rmi.RemoteException;
import java.util.List;

import businessLogic.manageBL.StrategyBL;
import po.SendPO;
import vo.SendVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.SendDataService;
import enumSet.Express;
import enumSet.PackType;

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
	
	
	public double getPrice(String city1, String city2,PackType paceType,Express expressType,double weight) throws RemoteException{
		//TODO  从StrategyBL 里得到距离，根据重量和速度计算时间，返回double类型数值
		StrategyBL strategyBL=new StrategyBL();
		double distance=strategyBL.getDistance(city1, city2);
		double packFare=0;//包装费
		double expressCoeff;//快递类型对应的系数，根据类型取不同的值
		
		for(Express temp: Express.values()){
			if(temp==expressType){
				expressCoeff=
			}
		}
		return 0;
	}
	
	

}
