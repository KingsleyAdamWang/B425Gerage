package businessLogic.logisticsBL;

import java.rmi.RemoteException;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import dataService.EntruckDataService;
import dataService.LogisticsDataService;
import po.EntruckPO;
import po.LogisticsPO;
import vo.LogisticsVo.LogisticsVO;

public class LogisticsBL {
	private LogisticsDataService logisticsDS;
	private List<LogisticsPO> logisticsList;
	
	public LogisticsBL() throws RemoteException {
		try {
			RMIHelper.initLogisticsDataService();
			logisticsDS = RMIHelper.getLogisticsDataService();
			logisticsList = logisticsDS.getLogisticsList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public String add(LogisticsVO vo){
		return null;
	}
	
	//当快递员收货之后填写寄件单后调用这个方法
	public String add(LogisticsPO po){
		for(LogisticsPO temp: logisticsList){
			if(temp.getId().equals(po.getId())){
				return "存在相同单号";
			}
		}
		logisticsList.add(po);
		return null;
	}
	
	//到达每个地点的营业厅或中转中心更新时调用这个方法
	public String update(String ID,String message) throws RemoteException{
		/*LogisticsPO newPO=po;
		List<String> messages=newPO.getMessages();
		messages.add(message);
		newPO.setMessages(messages);*/
		
		for(LogisticsPO temp: logisticsList){
			if(temp.getId().equals(ID)){
				temp.addMessages(message);
				return null;
			}
		}
		return "未找到对应快递单";
	}
	
	public LogisticsPO getLogisticsMessage(String id){
		return null;
	}
}
