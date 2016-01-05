package businessLogicService.inventoryBLService;

import java.rmi.RemoteException;

import vo.InventoryVo.ShipmentVO;

public interface ShipmentBLService {
	public String add(ShipmentVO vo) throws RemoteException;
	
	public String delete(ShipmentVO vo) throws RemoteException;
	
//	public List<ShipmentVO> getShipmentList();
//	
//	public List<ShipmentVO> getShipmentList(String institutionID) throws RemoteException;
//	
	public ShipmentVO find(String id) throws RemoteException;


}
