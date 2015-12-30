//未完成，先写前面的流程

package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.businessPO.DeliveryPO;
import vo.BussinessHallVo.DeliveryVO;
import vo.DeliverymanVo.SendVO;
import businessLogic.deliveryBL.SendBL;
import businessLogic.logisticsBL.LogisticsBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.businessHallDataService.DeliveryDataService;
import enumSet.ReceiptsState;

public class DeliveryBL {
	private DeliveryDataService deliveryDS;
	private List<DeliveryPO> deliveryList;
	
	public DeliveryBL() throws RemoteException {
		try {
			RMIHelper.initDeliveryDataService();
			deliveryDS = RMIHelper.getDeliveryDataService();
			deliveryList = deliveryDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public DeliveryVO search(String ID) throws RemoteException{
		DeliveryPO po=deliveryDS.find(ID);
		return new DeliveryVO(po);
	}
	
	public String add(DeliveryVO vo) throws RemoteException{
		DeliveryPO po=vo.transToPO();
		for(DeliveryPO temp: deliveryList){
			if(temp.equals(po)){
				return "存在相同派件单";
			}
		}
		
		deliveryList.add(po);
		deliveryDS.add(po);
		LogisticsBL logisticsBL=new LogisticsBL();
		logisticsBL.update(po.getId(), "正在派送");
		return null;
	}
	
	
	public String delete(DeliveryVO vo) throws RemoteException{
		DeliveryPO po=vo.transToPO();
		for(DeliveryPO temp: deliveryList){
			if(temp.equals(po)){
				deliveryList.remove(temp);
				deliveryDS.delete(po);
				return null;
			}
		}
		
		return "未找到对应派件单";
	}
	
	public String modify(DeliveryVO vo) throws RemoteException{
		DeliveryPO po=vo.transToPO();
		for(DeliveryPO temp: deliveryList){
			if(temp.equals(po)){
				deliveryList.set(deliveryList.indexOf(temp),po);
				deliveryDS.modify(po);
				return null;
			}
		}
		return "未找到对应派件单";
	}
	
	public SendVO getSendMessage(String ID) throws RemoteException{
		SendBL sendBL=new SendBL();
		return sendBL.getSend(ID);
	}

	public void approve(DeliveryPO po) throws RemoteException {
		deliveryDS.approve(po);
	}

	public void approveAll() throws RemoteException {
		deliveryDS.approveAll();
	}

	public List<DeliveryVO> getUnapproved() {
		List<DeliveryVO> result=new ArrayList<DeliveryVO>();
		for(DeliveryPO temp: deliveryList){
			if(temp.getState()==ReceiptsState.unapprove){
				result.add(new DeliveryVO(temp));
			}
		}
		return result;
	}
}
