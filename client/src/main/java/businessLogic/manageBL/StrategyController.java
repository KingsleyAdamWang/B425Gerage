package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.List;

import vo.PriceConstVO;
import businessLogicService.manageBLService.StrategyBLService;

public class StrategyController implements StrategyBLService {
	private StrategyBL strategyBL;
	
	public StrategyController() throws RemoteException{
		strategyBL=new StrategyBL();
	}
	
	public PriceConstVO getVO(){
		return strategyBL.getVO();
	}
	
	public String modify(PriceConstVO vo) throws RemoteException{
		return strategyBL.modify(vo);
	}
	
	public List<String> getCities(){
		return strategyBL.getCities();
	}
/*	public double calSendPrice(String city1, String city2, PackType packType, Express expressType){
		return strategyBL.calSendPrice(city1,city2,packType,expressType);
	}
	
	public double calTransFare(String city1, String city2){
		return strategyBL.calTransFare();
	}*/
	
}
