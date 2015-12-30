package businessLogic.intermediateBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.businessPO.EntruckPO;
import po.inventoryPO.EntryPO;
import vo.BussinessHallVo.EntruckVO;
import vo.InventoryVo.EntryVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.businessHallDataService.EntruckDataService;
import enumSet.ReceiptsState;

public class EntruckBL {
	private EntruckDataService entruckDS;
	private List<EntruckPO> entruckList;
	
	public EntruckBL() throws RemoteException {
		try {
			RMIHelper.initEntruckDataService();
			entruckDS = RMIHelper.getEntruckDataService();
			entruckList = entruckDS.getEntruckList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public EntruckVO search(String EntruckID) throws RemoteException{
		for(EntruckPO temp: entruckList){
			if(temp.getQyID()==EntruckID){
				return new EntruckVO(temp);
			}
		}
		return null;
		
		//DataService里有find方法
//		return new EntruckVO(entruckDS.find(EntruckID));
	}
	
	public String add(EntruckVO vo) throws RemoteException{
		EntruckPO po=vo.transToPO();
		
		for(EntruckPO temp: entruckList){
			if(temp.equals(po)){
				return "存在单号相同的装车单";
			}
		}
		
		entruckList.add(po);
		entruckDS.add(po);
		return null;
	}
	
	public String delete(EntruckVO vo) throws RemoteException{
		EntruckPO po=vo.transToPO();
		
		for(EntruckPO temp: entruckList){
			if(temp.equals(po)){
				entruckList.remove(temp);
				entruckDS.delete(temp);
				return null;
			}
		}
		return "未找到对应装车单";
	}
	
	public String modify(EntruckVO vo) throws RemoteException{
		EntruckPO po=vo.transToPO();
		
		for(EntruckPO temp: entruckList){
			if(temp.equals(po)){
				entruckDS.modify(po);
				//不知道这样更新entruckList行不行，试一下
				entruckList=entruckDS.getEntruckList();
				return null;
			}
		}
		
		return "未找到对应装车单";
	}
	
	//提供给别的BL使用的
	public List<String> getGoodsID(String entruckID) throws RemoteException{
		EntruckPO po=entruckDS.find(entruckID);
		
		return po.getIDlist();
	}
	
	public void approve(EntruckPO po) throws RemoteException {
		entruckDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		entruckDS.approvalAll();
	}

	public List<EntruckVO> getUnapproved() {
		List<EntruckVO> result=new ArrayList<EntruckVO>();
		for(EntruckPO temp: entruckList){
			if(temp.getState()==ReceiptsState.unapprove){
				result.add(new EntruckVO(temp));
			}
		}
		return result;
	}
}
