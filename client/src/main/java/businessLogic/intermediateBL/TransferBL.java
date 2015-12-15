package businessLogic.intermediateBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.TransferPO;
import po.ShipmentPO;
import po.TransferPO;
import vo.TransferVO;
import vo.TransferVO;
import businessLogic.inventoryBL.ShipmentBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.TransferDataService;
import enumSet.ReceiptsState;

public class TransferBL {
	TransferDataService transferDS;
	List<TransferPO> transferList;

	public TransferBL() throws RemoteException {
		try {
			RMIHelper.initTransferDataService();
			transferDS = RMIHelper.getTransferDataService();
			transferList = transferDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public String add(TransferVO vo) throws RemoteException{
		TransferPO po=vo.transToPO();
		for(TransferPO temp: transferList){
			if(temp.equals(po)){
				return "存在相同中转单号";
			}
		}
		
		transferList.add(po);
		transferDS.add(po);
		
		
		return null;
	}
	
	public String delete(TransferVO vo) throws RemoteException{
		TransferPO po=vo.transToPO();
		for(TransferPO temp: transferList){
			if(temp.equals(po)){
				transferList.remove(temp);
				transferDS.delete(po);
				return null;
			}
		}
		
		return "未找到对应中转单";
	}
	
	public List<String> getList(String transferID) throws RemoteException{
		ShipmentBL shipmentBL=new ShipmentBL();
		List<String> result=new ArrayList<String>();
		List<ShipmentPO> shipmentList=shipmentBL.getShipmentList();
		for(ShipmentPO temp : shipmentList){
			if(temp.getTransferID()==transferID){
				result.add(temp.getId());
			}
		}
		
		return result;
	}

//	public void approve(TransferPO po) throws RemoteException {
//		transferDS.approval(po);
//	}
//
//	public void approveAll() throws RemoteException {
//		transferDS.approvalAll();
//	}
//
//	public List<TransferVO> getUnapproved() {
//		List<TransferVO> result=new ArrayList<TransferVO>();
//		for(TransferPO temp: transferList){
//			if(temp.getState()==ReceiptsState.unapprove){
//				result.add(new TransferVO(temp));
//			}
//		}
//		return result;
//	}
}
