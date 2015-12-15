package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.EntryPO;
import po.EntryPO;
import vo.EntryVO;
import vo.EntryVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.EntryDataService;
import enumSet.ReceiptsState;

public class EntryBL {
	private EntryDataService entryDS;
	private List<EntryPO> entryList;
	private EntryPO entryPO;
	
	public EntryBL() throws RemoteException {
		try {
			RMIHelper.initEntryDataService();
			entryDS = RMIHelper.getEntryDataService();
			entryList = entryDS.getEntryList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public String add(EntryVO vo) throws RemoteException{
		entryPO = vo.transToPO();
		
		for(EntryPO temp: entryList){
			if(temp.equals(entryPO)){
				return "存在相同入库单号";
			}
		}
		
		entryPO.setState(ReceiptsState.unapprove);
		
		entryList.add(entryPO);
		entryDS.add(entryPO);
		return null;
	}
	
	public String delete(EntryVO vo) throws RemoteException{
		entryPO=vo.transToPO();
		for(EntryPO temp: entryList){
			if(temp.equals(entryPO)){
				entryList.remove(entryPO);
				entryDS.delete(entryPO);
				return null;
			}
		}
		
		return "未找到入库单";
	}
	
	public List<EntryPO> getEntryList(){
		return entryList;
	}
	
	public List<EntryPO> getEntryList(String institutionID) throws RemoteException{
		return entryDS.getEntryList(institutionID);
	}
	
	public EntryPO find(String ID) throws RemoteException{
		return entryDS.find(ID);
	}

	public void approve(EntryPO po) throws RemoteException {
		entryDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		entryDS.approvalAll();
	}

	public List<EntryVO> getUnapproved() {
		List<EntryVO> result=new ArrayList<EntryVO>();
		for(EntryPO temp: entryList){
			if(temp.getState()==ReceiptsState.unapprove){
				result.add(new EntryVO(temp));
			}
		}
		return result;
	}
}
