//未完成，先写前面的流程

package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
import vo.DeliveryVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.DeliveryDataService;

public class DeliveryBL {
	private DeliveryDataService deliveryDS;
//	private List<DeliveryPO> deliveryList;
	
	public DeliveryBL() throws RemoteException {
		try {
			RMIHelper.initDeliveryDataService();
			deliveryDS = RMIHelper.getDeliveryDataService();
//			deliveryList = deliveryDS.;
//DataService中没有返回list方法，只有查找一个PO的方法
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public DeliveryVO search(String ID){
		DeliveryPO po=deliveryDS.find(ID);
		DeliveryVO vo=new DeliveryVO();
		
		return new DeliveryVO(po);
	}
}
