package businessLogic.intermediateBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.intermidatePO.TransferPO;
import po.inventoryPO.ShipmentPO;
import po.managePO.InstitutionPO;
import vo.DeliverymanVo.SendVO;
import vo.IntermediateVo.TransferVO;
import vo.ManageVo.InstitutionVO;
import vo.ManageVo.PriceConstVO;
import businessLogic.deliveryBL.SendBL;
import businessLogic.inventoryBL.ShipmentBL;
import businessLogic.manageBL.InstitutionBL;
import businessLogic.manageBL.StaffBL;
import businessLogic.manageBL.StrategyBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.intermidateDataService.TransferDataService;
import enumSet.InsType;
import enumSet.ReceiptsState;
import enumSet.TransportType;

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

	public String add(TransferVO vo) throws RemoteException {
		TransferPO po = vo.transToPO();
		for (TransferPO temp : transferList) {
			if (temp.equals(po)) {
				return "存在相同中转单号";
			}
		}

		transferList.add(po);
		transferDS.add(po);
		return null;
	}

	public String delete(TransferVO vo) throws RemoteException {
		TransferPO po = vo.transToPO();
		for (TransferPO temp : transferList) {
			if (temp.equals(po)) {
				transferList.remove(temp);
				transferDS.delete(po);
				return null;
			}
		}

		return "未找到对应中转单";
	}

	public List<String> getList(String transferID) throws RemoteException {
		ShipmentBL shipmentBL = new ShipmentBL();
		List<String> result = new ArrayList<String>();
		List<ShipmentPO> shipmentList = shipmentBL.getShipmentList();
		for (ShipmentPO temp : shipmentList) {
			if (temp.getTransferID() == transferID) {
				result.add(temp.getId());
			}
		}

		return result;
	}

	public List<String> getCities() throws RemoteException {
		StrategyBL strategyBL = new StrategyBL();
		return strategyBL.getCities();
	}

	public List<InstitutionVO> getInstituitonList(String userID)
			throws RemoteException {
		List<InstitutionVO> result = new ArrayList<InstitutionVO>();
		InstitutionBL insBL = new InstitutionBL();
		StaffBL staffBL=new StaffBL();
		String institutionID=(staffBL.getUser(userID).getInstitutionID());
		InstitutionPO institutionPO=insBL.searchInstitution(institutionID);
		List<InstitutionPO> insList = insBL.getInsList();
		// for(InstitutionPO temp: insList){
		// if(temp.getCity()==po.getCity()){
		// if(temp.getInstitutionID()!=po.getInstitutionID()){
		// result.add(temp.getName());
		// }
		// }
		// }
		for (InstitutionPO temp : insList) {
			if ((temp.getName() != institutionPO.getName())
					&& (temp.getType() == InsType.intermediate)) {
				result.add(new InstitutionVO(temp));
			}
		}

		return result;
	}

	public double getFare(TransferPO transferPO) throws RemoteException {
		List<String> sendList=new ArrayList<String>();
		StrategyBL strategyBL = new StrategyBL();
		PriceConstVO priceVO = strategyBL.getVO();
		double fare = 0;
		double tCoeff = 0;
		double weight = 0;
		double distance =0;
		SendBL sendBL = new SendBL();
		List<SendVO> sendVOList = new ArrayList<SendVO>();
		for (String temp : sendList) {
			if (sendBL.getSend(temp) != null) {
				weight = weight + sendBL.getSend(temp).weight;
			}
		}

		if (transferPO.getType()==TransportType.PLANE) {
			tCoeff = 20;
		} else {
			if (transferPO.getType()==TransportType.TRAIN) {
				tCoeff = 0.2;
			} else {
				tCoeff = 2;
			}
		}
		fare = distance * tCoeff * weight/1000;
		return fare;
	}

	public void approve(TransferPO po) throws RemoteException {
		transferDS.approve(po);
	}

	public void approveAll() throws RemoteException {
		transferDS.approveAll();
	}

	public List<TransferVO> getUnapproved() {
		List<TransferVO> result = new ArrayList<TransferVO>();
		for (TransferPO temp : transferList) {
			if (temp.getState() == ReceiptsState.unapprove) {
				result.add(new TransferVO(temp));
			}
		}
		return result;
	}
}
