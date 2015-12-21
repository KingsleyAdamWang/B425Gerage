package businessLogic.logisticsBL;

import java.rmi.RemoteException;
import java.util.List;

import po.LogisticsPO;
import vo.LogisticsVo.LogisticsVO;
import businessLogicService.logisticsBLService.LogisticsBLService;
import client.ClientInitException;
import client.RMIHelper;
import dataService.LogisticsDataService;

/**
 * 
 * 查询物流信息的逻辑实现类
 *
 */
public class LogisticsController implements LogisticsBLService {
	private LogisticsBL logisticsBL;
	
	public LogisticsController() throws ClientInitException, RemoteException{
		logisticsBL=new LogisticsBL();
	}
	
	public String add(LogisticsPO po){
		return logisticsBL.add(po);
	}
	
	public String update(String ID,String message) throws RemoteException{
		return logisticsBL.update(ID,message);
	}
	
	public List<LogisticsVO> getLogisticsList(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public LogisticsVO getLogisticsMessage(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
