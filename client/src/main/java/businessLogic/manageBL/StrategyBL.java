package businessLogic.manageBL;

import java.rmi.RemoteException;

import po.PriceConstPO;
import vo.PriceConstVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.PriceConstDataService;
import enumSet.Express;
import enumSet.PackType;

public class StrategyBL {
	private PriceConstDataService pcDS;
	private PriceConstPO pcPO;
	public  StrategyBL() throws RemoteException {
		try {
			RMIHelper.initPriceConstDataService();
			pcDS = RMIHelper.getPriceConstDataService();
			pcPO=pcDS.getPriceConst();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	
	public PriceConstVO getVO(){
		if(pcPO!=null){
			PriceConstVO vo=new PriceConstVO(pcPO);
			return vo;
		}
		
		return null;
	}
	
	public String modify(PriceConstVO vo) throws RemoteException{
		PriceConstPO po=vo.transToPO();
		pcDS.update(po);
		return null;
	}
	
	

/*	public double calSendPrice(String city1, String city2, PackType packType, Express expressType) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double calTransFare() {
		// TODO Auto-generated method stub
		return 0;
	}*/
	


}
