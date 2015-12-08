package businessLogic.inventoryBL;

import java.rmi.RemoteException;
import java.util.List;

import po.ShipmentPO;
import vo.ShipmentVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.ShipmentDataService;

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
}
