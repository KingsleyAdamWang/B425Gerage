package businessLogic.businessHallBL;

import java.lang.Thread.State;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.EntruckPO;
import vo.ArrivalVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.ArrivalDataService;
import dataService.EntruckDataService;
import enumSet.ReceiptsState;

public class ArrivalBL {
	private ArrivalDataService arrivalDS;
	private List<ArrivalPO> arrivalList;
	
	public ArrivalBL() throws RemoteException {
		try {
			RMIHelper.initArrivalDataService();
			arrivalDS = RMIHelper.getArrivalDataService();
			arrivalList = arrivalDS.getArrivalList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public ArrivalVO search(String transferID){
		for(ArrivalPO temp: arrivalList){
			if(temp.getTransferId().equals(transferID)){
				return new ArrivalVO(temp);
			}
		}
		return null;
	}
	
	public String add(ArrivalVO vo) throws RemoteException{
		ArrivalPO po=vo.transToPO();
		
		for(ArrivalPO temp:arrivalList){
			if(temp.equals(po)){
				return "存在相同到达单";
			}
		}
		
		po.setState(ReceiptsState.unapprove);

		arrivalList.add(po);
		arrivalDS.add(po);
		//TODO 更新对应的物流信息
		return null;
	}
	
	public String delete(ArrivalVO vo) throws RemoteException{
		ArrivalPO po=vo.transToPO();
		
		for(ArrivalPO temp: arrivalList){
			if(temp.equals(po)){
				arrivalList.remove(temp);
				arrivalDS.delete(po);
			}
		}
		return "未找到到达单";
	}
	
	public String modify(ArrivalVO vo) throws RemoteException{
		ArrivalPO po=vo.transToPO();
		
		for(ArrivalPO temp : arrivalList){
			if(temp.equals(po)){
				arrivalList.remove(temp);
				arrivalList.add(po);
				
				arrivalDS.modify(po);
				return null;
			}
		}
		
		return "未找到对应到达单";
	}
	
	//通过装车单单号查询对应的所有快递单号列表
	public List<String> getIDList(String entruckID) throws RemoteException{
//		EntruckDataService entruckDS=new EntruckDataService();
		
		try {
			RMIHelper.initEntruckDataService();
			EntruckDataService entruckDS = RMIHelper.getEntruckDataService();
			EntruckPO entruckPO=entruckDS.find(entruckID);
			return entruckPO.getIDlist();
			//		List<EntruckPO> entruckList = entruckDS.getEntruckList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		
	}
}
