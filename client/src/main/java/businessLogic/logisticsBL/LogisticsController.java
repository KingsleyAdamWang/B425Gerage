package businessLogic.logisticsBL;

import java.rmi.RemoteException;

import po.logisticsPO.LogisticsPO;
import vo.LogisticsVo.LogisticsVO;
import businessLogicService.logisticsBLService.LogisticsBLService;
import client.ClientInitException;

/**
 * 
 * 查询物流信息的逻辑实现类
 *
 */
public class LogisticsController implements LogisticsBLService {
	private LogisticsBL logisticsBL;

	public LogisticsController() throws ClientInitException, RemoteException {
		logisticsBL = new LogisticsBL();
	}

	public String add(LogisticsPO po) throws RemoteException {
		return logisticsBL.add(po);
	}

	public String update(String ID, String message) throws RemoteException {
		return logisticsBL.update(ID, message);
	}

	public LogisticsVO getLogisticsMessage(String id) {

		return logisticsBL.getLogisticsMessage(id);
	}

}
