package edms.businesslogic;

import java.rmi.RemoteException;
import java.util.List;

import edms.businesslogicservice.InquireBLService;
import edms.data.DataFactory;
import edms.po.LogisticsPO;
import edms.vo.LogisticsVO;

public class InquireBL implements InquireBLService {
	private DataFactory dataFactory;

	public InquireBL() {
		dataFactory = new DataFactory();
	}

	public List<LogisticsVO> getLogisticsList(String id) {
		LogisticsPO po;
		try {
			po = dataFactory.getLogisticsData().find(id);
			List<LogisticsVO> vlist = po.getVList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vlist;
	}
}
