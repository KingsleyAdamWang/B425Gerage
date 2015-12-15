package businessLogic.deliveryBL;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.List;

import businessLogic.manageBL.StrategyBL;
import po.PriceConstPO;
import po.SendPO;
import util.PackPrice;
import vo.SendVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.PriceConstDataService;
import dataService.SendDataService;
import enumSet.Express;
import enumSet.PackType;

public class SendBL {
	SendDataService sendDS;
	List<SendPO> sendList;

	public SendBL() throws RemoteException {
		try {
			RMIHelper.initSendDataService();
			sendDS = RMIHelper.getSendDataService();
			sendList = sendDS.getSendList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public String add(SendVO vo) throws RemoteException {
		SendPO po = vo.transToPO();
		for (SendPO temp : sendList) {
			if (temp.getId().equals(po.getId()))
				return "存在相同编号的快递单";
		}
		sendList.add(po);
		sendDS.add(po);

		return null;
	}

	public String delete(SendVO vo) throws RemoteException {
		SendPO po = vo.transToPO();
		for (SendPO temp : sendList) {
			if (temp.getId().equals(vo.getId())) {
				sendList.remove(temp);
				sendDS.delete(temp);
				return null;
			}
		}

		return "未找到对应快递单";
	}

	public double getWeight(double weight,double length,double width, double height){
		double result=0;
		double newWeight=0;
		newWeight=length*width*height;
		if(weight>newWeight){
			return weight;
		}else{
			return newWeight;
		}
	}
	
	public double getPrice(String city1, String city2, PackType packType,
			Express expressType, double weight,double length,double width,double height) throws RemoteException,
			ClientInitException {
		RMIHelper.initPriceConstDataService();
		PriceConstDataService pcDS = RMIHelper.getPriceConstDataService();
		PriceConstPO pcPO = pcDS.getPriceConst();

		// TODO 从StrategyBL 里得到距离，根据重量和速度计算时间，返回double类型数值
		double result;
		StrategyBL strategyBL = new StrategyBL();
		double distance = strategyBL.getDistance(city1, city2);
		double packFare = 0;// 包装费
		double expressCoeff = 0;// 快递类型对应的系数，根据类型取不同的值

		//计算运送种类不同对应的系数
		if (expressType == Express.STANDARD) {
			expressCoeff = pcPO.getStandard();
		} else if (expressType == Express.FAST) {
			expressCoeff = pcPO.getFast() ;
		} else if (expressType == Express.ECONOMY) {
			expressCoeff = pcPO.getEconomy();
		}
		//得到包装费
		List<PackPrice> packs=pcPO.getPackPrice();
		for(PackPrice temp : packs){
			if(temp.getType()==packType){
				packFare=temp.getFare();
				break;
			}
		}
		
		weight=this.getWeight(weight,length,width,height);
		
		result=(distance/1000)*expressCoeff*weight+packFare;
		//格式转化为2位小数
		DecimalFormat df = new DecimalFormat("#.00");  
		

		return Double.parseDouble(df.format(result));
	}
	
	public int getTime(SendVO sendVO){
		return 0;
	}

}
