package businessLogicsService;

import java.rmi.RemoteException;
import java.util.List;

import vo.LogisticsVO;

public interface InquireBLService {
	public List<LogisticsVO> getLogisticsList(String id) throws RemoteException;
	
}
