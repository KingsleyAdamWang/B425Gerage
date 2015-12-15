package businessLogic.businessHallBL;

import java.rmi.RemoteException;

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
}
