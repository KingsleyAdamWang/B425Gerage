package businessLogic.businessHallBL;

import java.rmi.RemoteException;

import vo.BussinessHallVo.TruckVO;
import businessLogic.logBL.LogBL;
import businessLogicService.businessHallBLService.TruckBLService;

public class TruckController implements TruckBLService {
	TruckBL truckBL;
	LogBL logBL;

	public TruckController() {

		try {
			logBL = new LogBL();
			truckBL = new TruckBL();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public TruckVO find(String id) {
		return new TruckVO(truckBL.find(id));
	}

	public String add(TruckVO vo) {
		return truckBL.add(vo.transToPO());
	}

	public String delete(TruckVO vo) {
		return truckBL.delete(vo.transToPO());
	}

	public String modify(TruckVO vo) {
		return truckBL.modify(vo.transToPO());
	}

	public TruckVO check(String message) {
		return null;
	}

}
