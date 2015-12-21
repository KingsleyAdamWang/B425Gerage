package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.ShipmentPO;
import po.ShipmentPO;
import vo.InventoryVo.ShipmentVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.inventoryDataService.ShipmentDataService;
import enumSet.ReceiptsState;

public class ShipmentBL {
	private ShipmentDataService ShipmentDS;
	private List<ShipmentPO> ShipmentList;
	private ShipmentPO ShipmentPO;
	
	public ShipmentBL() throws RemoteException {
		try {
			RMIHelper.initShipmentDataService();
			ShipmentDS = RMIHelper.getShipmentDataService();
			ShipmentList = ShipmentDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public String add(ShipmentVO vo) throws RemoteException{
		ShipmentPO = vo.transToPO();
		
		for(ShipmentPO temp: ShipmentList){
			if(temp.equals(ShipmentPO)){
				return "存在相同出库单号";
			}
		}
		
		ShipmentPO.setState(ReceiptsState.unapprove);
		
		ShipmentList.add(ShipmentPO);
		ShipmentDS.add(ShipmentPO);
		return null;
	}
	
	public String delete(ShipmentVO vo) throws RemoteException{
		ShipmentPO=vo.transToPO();
		for(ShipmentPO temp: ShipmentList){
			if(temp.equals(ShipmentPO)){
				ShipmentList.remove(ShipmentPO);
				ShipmentDS.delete(ShipmentPO);
				return null;
			}
		}
		
		return "未找到出库单";
	}
	
	public List<ShipmentPO> getShipmentList(){
		return ShipmentList;
	}
	
	public List<ShipmentPO> getShipmentList(String institutionID) throws RemoteException{
		return ShipmentDS.getListByIns(institutionID);
	}
	
	public ShipmentPO find(String ID) throws RemoteException{
		return ShipmentDS.find(ID);
	}

	public void approve(ShipmentPO po) throws RemoteException {
		ShipmentDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		ShipmentDS.approvalAll();
	}

	public List<ShipmentVO> getUnapproved() {
		List<ShipmentVO> result=new ArrayList<ShipmentVO>();
		for(ShipmentPO temp: ShipmentList){
			if(temp.getState()==ReceiptsState.unapprove){
				result.add(new ShipmentVO(temp));
			}
		}
		return result;
	}
}
