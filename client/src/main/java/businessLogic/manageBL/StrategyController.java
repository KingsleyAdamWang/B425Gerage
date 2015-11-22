package businessLogic.manageBL;

import java.rmi.RemoteException;

import businessLogicService.manageBLService.StrategyBLService;
import enumSet.Express;
import enumSet.PackType;

public class StrategyController implements StrategyBLService {
	private StrategyBL strategyBL;
	
	public StrategyController() throws RemoteException{
		strategyBL=new StrategyBL();
	}
	
/*	public double calSendPrice(String city1, String city2, PackType packType, Express expressType){
		return strategyBL.calSendPrice(city1,city2,packType,expressType);
	}
	
	public double calTransFare(String city1, String city2){
		return strategyBL.calTransFare();
	}*/
	
}
