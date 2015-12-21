package businessLogicService.logisticsBLService;

import java.rmi.RemoteException;
import java.util.List;

import vo.LogisticsVo.LogisticsVO;

public interface InquireBLService {
	public List<LogisticsVO> getLogisticsList(String id) throws RemoteException;
	
}
