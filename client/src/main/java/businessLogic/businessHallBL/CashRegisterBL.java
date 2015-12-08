package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.List;

import po.CashRegisterPO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.CashRegisterDataService;

public class CashRegisterBL {
	CashRegisterDataService invDS;
	List<CashRegisterPO> invList;

	public CashRegisterBL() throws RemoteException {
		try {
			RMIHelper.initCashRegisterDataService();
			invDS = RMIHelper.getCashRegisterDataService();
			invList = invDS.getCashRegisterList();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
}
