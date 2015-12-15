package businessLogic.businessHallBL;

import java.lang.Thread.State;
import java.rmi.RemoteException;
import java.util.List;

import businessLogic.logisticsBL.LogisticsBL;
import po.ArrivalPO;
import po.EntruckPO;
import po.TransferPO;
import vo.ArrivalVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.ArrivalDataService;
import dataService.EntruckDataService;
import dataService.TransferDataService;
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
	
//	public ArrivalVO newArrival(){
//		ArrivalVO arrivalVO=new ArrivalVO(new ArrivalPO());
//		arrivalVO.
//	}
	
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
		
		//更新物流信息
		//第一次的TransferID就是装车单，这些TransferID需要人工填入
		List<String> goodsID=getIDList(po.getTransferId());
		businessLogic.manageBL.InstitutionBL insBL=new businessLogic.manageBL.InstitutionBL();
		String insName=insBL.searchInstitution(po.getInstitutionID()).getName();
		updateLogistics(goodsID,insName);
		return null;
	}
	
	public String updateLogistics(List<String> goodsID,String institutionName) throws RemoteException{
		LogisticsBL logisticsBL=new LogisticsBL();
		for(String temp: goodsID){
			logisticsBL.update(temp, "到达"+institutionName);
		}
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
	

	
	//通过中转单单号查询对应的所有快递单号列表
	public List<String> getIDList(String transferID) throws RemoteException{
//		EntruckDataService entruckDS=new EntruckDataService();
		
		try {
			RMIHelper.initTransferDataService();
			TransferDataService transferDS = RMIHelper.getTransferDataService();
			TransferPO transferPO=transferDS.find(transferID);
			return transferPO.getList();
			//		List<EntruckPO> entruckList = entruckDS.getEntruckList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		
	}
	public List<ArrivalVO> getUnapproveArrival(){
		
		return null;
	}

	public void approve() {
		// TODO Auto-generated method stub
		
	}

	public void approveAll() {
		// TODO Auto-generated method stub
		
	}
}
