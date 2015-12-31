package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.BussinessHallVo.TruckVO;
import vo.LogVo.LogVO;
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

	public TruckVO find(String id) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"查询车辆信息"));
		return new TruckVO(truckBL.find(id));
	}

	public String add(TruckVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增车辆信息"));
		return truckBL.add(vo.transToPO());
	}

	public String delete(TruckVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除车辆信息"));
		return truckBL.delete(vo.transToPO());
	}

	public String modify(TruckVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"修改车辆信息"));
		return truckBL.modify(vo.transToPO());
	}
	
	public List<TruckVO> getAllTruckVOList(){
		return truckBL.getAllTruckVOList();
	}
	public TruckVO check(String message) {
		return null;
	}

}
