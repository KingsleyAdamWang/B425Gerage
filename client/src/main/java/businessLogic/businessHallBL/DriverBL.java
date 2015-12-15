package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.List;

import po.DriverPO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.DriverDataService;

public class DriverBL {
	DriverDataService driverDS;
	List<DriverPO> driverList;
	
	public DriverBL() throws RemoteException {
		try {
			RMIHelper.initDriverDataService();
			driverDS = RMIHelper.getDriverDataService();
			driverList = driverDS.;
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public addDriver(Driver)
	
}
