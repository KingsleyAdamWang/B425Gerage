package businessLogic.intermediateBL;

import java.rmi.RemoteException;
import java.util.List;

import po.TransferPO;
import vo.TransferVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.TransferDataService;

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
	
	public String add(TransferVO vo){
		TransferPO po=vo.transferToPO();
		for(TransferPO temp: transferList){
			if(temp.equals(po)){
				return "存在相同中转单号";
			}
		}
		
		
		return null;
	}
}
