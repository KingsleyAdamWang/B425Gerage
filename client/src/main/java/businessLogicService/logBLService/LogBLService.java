package businessLogicService.logBLService;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import vo.LogVo.LogVO;

public interface LogBLService {
	public List<LogVO> getAllLogList();
	
	public List<LogVO> getLogListOfDate(Date d);
	
	public List<LogVO> getLogListOfUser(String userID);
	
	public String add(LogVO vo) throws RemoteException;
	
	public List<LogVO> getLogList(); 

}
