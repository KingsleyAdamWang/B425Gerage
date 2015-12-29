package businessLogic.logisticsBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import dataService.businessHallDataService.EntruckDataService;
import dataService.logisticsDataService.LogisticsDataService;
import po.businessPO.EntruckPO;
import po.logisticsPO.LogisticsPO;
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
	
	//当快递员收货之后填写寄件单后调用这个方法
	public String add(LogisticsPO po) throws RemoteException{
		for(LogisticsPO temp: logisticsList){
			if(temp.getId().equals(po.getId())){
				return "存在相同单号";
			}
		}
		logisticsList.add(po);
		logisticsDS.add(po);
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
				logisticsDS.modify(ID, message);
				return null;
			}
		}
		return "未找到对应快递单";
	}
	
	public LogisticsVO getLogisticsMessage(String id){
		for(LogisticsPO temp: logisticsList){
			if(temp.getId().equals(id)){
				return new LogisticsVO(temp); 
			}
		}
		List<String> messages=new ArrayList<String>(4);
		messages.add("无法查询到该单号对应的物流信息");
		messages.add("可能原因为：");
		messages.add("单号填写错误，请检查单号");
		messages.add("快件接收后还未录入物流系统，请耐心等待");
		return new LogisticsVO(id,"未知",messages);
	}
	
}
