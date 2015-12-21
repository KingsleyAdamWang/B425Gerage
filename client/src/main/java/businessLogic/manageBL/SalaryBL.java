package businessLogic.manageBL;

import java.rmi.RemoteException;

import po.managePO.SalaryPO;
import vo.ManageVo.SalaryVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.manageDataService.SalaryDataService;

public class SalaryBL {
	private SalaryDataService salaryDS;
	private SalaryPO salaryPO;
	
	public SalaryBL() throws RemoteException {
		try {
			RMIHelper.initSalaryDataService();
			salaryDS = RMIHelper.getSalaryDataService();
			salaryPO=salaryDS.getSalaryPO();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public SalaryPO getSalaryPO(){
		return salaryPO;
	}
	
	public String modify(SalaryVO vo) throws RemoteException{
		SalaryPO po=vo.transToPO();
		salaryDS.modify(po);
		return null;
	}

}
