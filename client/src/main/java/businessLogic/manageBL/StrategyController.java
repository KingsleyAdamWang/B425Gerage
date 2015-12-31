package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.LogVo.LogVO;
import vo.ManageVo.PriceConstVO;
import businessLogic.logBL.LogBL;
import businessLogicService.manageBLService.StrategyBLService;

public class StrategyController implements StrategyBLService {
	private StrategyBL strategyBL;
	private LogBL logBL;

	public StrategyController() throws RemoteException {
		strategyBL = new StrategyBL();
		logBL = new LogBL();
	}

	public PriceConstVO getVO() throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"查询价格常量信息"));
		return strategyBL.getVO();
	}

	public String modify(PriceConstVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"修改价格常量信息"));
		return strategyBL.modify(vo);
	}

	public List<String> getCities() {

		return strategyBL.getCities();
	}

	public double getDistance(String city1, String city2) {
		return strategyBL.getDistance(city1, city2);
	}
	/*
	 * public double calSendPrice(String city1, String city2, PackType packType,
	 * Express expressType){ return
	 * strategyBL.calSendPrice(city1,city2,packType,expressType); }
	 * 
	 * public double calTransFare(String city1, String city2){ return
	 * strategyBL.calTransFare(); }
	 */

}
