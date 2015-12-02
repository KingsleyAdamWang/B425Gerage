package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.EntruckPO;
import vo.EntruckVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.EntruckDataService;

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
/*		for(EntruckPO temp: entruckList){
			if(temp.getQyID()==EntruckID){
				return new EntruckVO(temp);
			}
		}
		return null;*/
		
		//发现DataService里有find方法。如果没有，用上面注释的内容应该也行。
		return new EntruckVO(entruckDS.find(EntruckID));
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
				this.entruckList=entruckDS.getEntruckList();
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
	
}
