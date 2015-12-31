package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import presentation.MainFrame;
import vo.BussinessHallVo.DriverVO;
import vo.LogVo.LogVO;
import businessLogic.logBL.LogBL;
import businessLogicService.businessHallBLService.DriverBLService;

public class DriverController implements DriverBLService {
	private DriverBL driverBL;
	private LogBL logBL;

	public DriverController() {
		try {
			driverBL = new DriverBL();
			logBL = new LogBL();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DriverVO find(String id) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"查询司机信息"));
		return driverBL.find(id);
	}

	public String addDriver(DriverVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增司机信息"));
		return driverBL.addDriver(vo.transtoPO());
	}

	public String delete(DriverVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除司机信息"));
		return driverBL.deleteDriver(vo.transtoPO());
	}

	public String modify(DriverVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"修改司机信息"));
		return driverBL.modify(vo.transtoPO());
	}

	public List<DriverVO> getDriversByIns(String institutionID) {
		return driverBL.getDriversByIns(institutionID);
	}

	public List<String> getDriverNamesByIns(String institutionID) {
		return driverBL.getDriverNamesByIns(institutionID);
	}
}
