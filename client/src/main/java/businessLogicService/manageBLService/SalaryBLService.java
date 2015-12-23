package businessLogicService.manageBLService;

import java.rmi.RemoteException;

import vo.ManageVo.SalaryVO;

public interface SalaryBLService {
	public SalaryVO getSalary() throws RemoteException;
	
	public String modify(SalaryVO vo) throws RemoteException;
}
