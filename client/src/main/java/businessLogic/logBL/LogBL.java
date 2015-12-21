package businessLogic.logBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import dataService.LogDataService;
import po.LogPO;
import vo.LogVo.LogVO;

public class LogBL {
	LogDataService logDS;
	List<LogPO> logList; 
	
	public  LogBL() throws RemoteException {
		try {
			RMIHelper.initLogDataService();
			logDS = RMIHelper.getLogDataService();
			logList=logDS.getLogList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public List<LogVO> getAllLogList(){
		List<LogVO> result=new ArrayList<LogVO>();
		for(LogPO temp : logList){
			result.add(new LogVO(temp));
		}
		return result;
	}
	
	public List<LogVO> getLogOfDate(Date d){
		List<LogVO> result = new ArrayList<LogVO>();
		
		for(LogPO temp : logList){
			if(temp.getD()==d){
				result.add(new LogVO(temp));
			}
		}
		return result;
		
	}
	
	public List<LogVO> getLogOfUser(String userID){
		List<LogVO> result = new ArrayList<LogVO>();
		
		for(LogPO temp : logList){
			if(temp.getIdentityID()==userID){
				result.add(new LogVO(temp));
			}
		}
		return result;
	}
	
	public String add(LogVO vo) throws RemoteException{
		LogPO po=vo.transToPO();
		logList.add(0,po);
		logDS.add(po);
		
		return null;
	}
	
}
