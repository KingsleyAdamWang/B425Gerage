package businessLogic_Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.LogisticsVo.LogisticsVO;
import businessLogicService.logisticsBLService.InquireBLService;

public class InquireBLStub implements InquireBLService {

	
	public List<LogisticsVO> getLogisticsList(String id) throws RemoteException {
		List<LogisticsVO> list = new ArrayList<LogisticsVO>();
//		list.add(new LogisticsVO(new Date(), null, "王栋", null));
//		list.add(new LogisticsVO(new Date(), "南京市中转中心"));
//		list.add(new LogisticsVO(new Date(), "栖霞区营业厅"));
//		list.add(new LogisticsVO(new Date(), null, "汪盼", "6666666"));
		return list;
	}

}
