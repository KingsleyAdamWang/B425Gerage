package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.List;

import vo.BussinessHallVo.DriverVO;
import businessLogic.logBL.LogBL;
import businessLogicService.businessHallBLService.DriverBLService;

public class DriverController implements DriverBLService {
	private DriverBL driverBL;
	private LogBL logBL;
	
	public DriverController(){
		try {
			driverBL=new DriverBL();
			logBL=new LogBL();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DriverVO find(String id){
		return driverBL.find(id);
	}
	
	public String addDriver(DriverVO vo){
		return driverBL.addDriver(vo.transtoPO());
	}
	
	public String delete(DriverVO vo){
		return driverBL.deleteDriver(vo.transtoPO());
	}
	
	public String modify(DriverVO vo){
		return driverBL.modify(vo.transtoPO());
	}
	public List<DriverVO> getDriversByIns(String institutionID){
		return getDriversByIns(institutionID);
	}
	
	public List<String> getDriverNamesByIns(String institutionID){
		return driverBL.getDriverNamesByIns(institutionID);
	}
}
