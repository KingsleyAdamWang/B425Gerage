package businessLogic.intermediateBL;

import java.lang.Thread.State;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
	
	public ArrivalVO search(String transferID){
		for(ArrivalPO temp: arrivalList){
			if(temp.getTransferId().equals(transferID)){
				return new ArrivalVO(temp);
			}
		}
		return null;
	}
	
	public String add(ArrivalVO vo) throws RemoteException, ClientInitException{
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
		//第一次的TransferID就是装车单单号,之后的是中转单单号，这些TransferID需要人工填入
		//先从装车单里找，找不到就到中转单里找= =
		List<String> goodsID=getIDListFromEntruck(po.getTransferId());
		if(goodsID==null){
			goodsID=getIDListFromTransfer(po.getTransferId());
		}
		businessLogic.manageBL.InstitutionBL insBL=new businessLogic.manageBL.InstitutionBL();
		String insName=insBL.searchInstitution(po.getInstitutionID()).getName();
		updateLogisticsFromB(goodsID,insName);
		return null;
	}
	
	
	
	public String updateLogisticsFromB(List<String> goodsID,String institutionName) throws RemoteException{
		LogisticsBL logisticsBL=new LogisticsBL();
		for(String temp: goodsID){
			logisticsBL.update(temp, "到达"+institutionName);
		}
		return null;
	} 
	
	public String updateLogisticsFromI(List<String> goodsID){
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
	public List<String> getIDListFromEntruck(String entruckID) throws RemoteException{
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
	
	public List<String> getIDListFromTransfer(String transferID) throws ClientInitException, RemoteException{
		RMIHelper.initTransferDataService();
		TransferDataService transferDS=RMIHelper.getTransferDataService();
		TransferPO transferPO=transferDS.find(transferID);
		return transferPO.getList();
	}
	
	public void approve(ArrivalPO po) throws RemoteException {
		arrivalDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		arrivalDS.approvalAll();
	}

	public List<ArrivalVO> getUnapproved() {
		List<ArrivalVO> result=new ArrayList<ArrivalVO>();
		for(ArrivalPO temp: arrivalList){
			if(temp.getState()==ReceiptsState.unapprove){
				result.add(new ArrivalVO(temp));
			}
		}
		return result;
	}
}
