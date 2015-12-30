package businessLogicService.logisticsBLService;

import java.rmi.RemoteException;

import po.logisticsPO.LogisticsPO;
import vo.LogisticsVo.LogisticsVO;

public interface LogisticsBLService {
	public String add(LogisticsPO po) throws RemoteException;
	
	public String update(String ID,String message) throws RemoteException;
	
	public LogisticsVO getLogisticsMessage(String id);
}
