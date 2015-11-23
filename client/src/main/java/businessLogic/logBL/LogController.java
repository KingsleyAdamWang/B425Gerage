package businessLogic.logBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import vo.LogVO;
import businessLogicService.logBLService.LogBLService;

public class LogController implements LogBLService {
	LogBL logBL;
	public LogController() throws RemoteException{
		logBL= new LogBL();
	}
	
	public List<LogVO> getAllLogList(){
		return logBL.getAllLogList();
	}
	
	public List<LogVO> getLogListOfDate(Date d){
		return logBL.getLogOfDate(d);
	}
	
	public List<LogVO> getLogListOfUser(String userID){
		return logBL.getLogOfUser(userID);
	}
	
	public String add(LogVO vo) throws RemoteException{
		return logBL.add(vo);
	}
	
	public List<LogVO> getLogList(){
		return null;
	}

}
