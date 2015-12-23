package businessLogicService.manageBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.ManageVo.PriceConstVO;

public interface StrategyBLService {
	public PriceConstVO getVO();
	
	public String modify(PriceConstVO vo) throws RemoteException;
	
	public List<String> getCities();
	
	public double getDistance(String city1,String city2);
}
