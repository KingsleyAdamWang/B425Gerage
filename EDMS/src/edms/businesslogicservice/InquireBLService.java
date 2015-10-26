package edms.businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import edms.vo.LogisticsVO;

public interface InquireBLService {
	public List<LogisticsVO> getLogisticsList(String id) throws RemoteException;
}
