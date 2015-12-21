package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.Date;

import presentation.MainFrame;
import vo.LogVo.LogVO;
import vo.ManageVo.SalaryVO;
import businessLogic.logBL.LogBL;
import businessLogicService.manageBLService.SalaryBLService;

public class SalaryController implements SalaryBLService {
	private SalaryBL salaryBL;
	private LogBL logBL;
	
	public SalaryController() throws RemoteException{
		salaryBL=new SalaryBL();
		logBL=new LogBL();
	}
	
	public SalaryVO getSalary() throws RemoteException{
		logBL.add(new LogVO(new Date(),MainFrame.getUser().getIdentityID(),"查询工资信息"));
		return new SalaryVO(salaryBL.getSalaryPO());
	}
	
	public String modify(SalaryVO vo) throws RemoteException{
		logBL.add(new LogVO(new Date(),MainFrame.getUser().getIdentityID(),"更改工资信息"));
		return salaryBL.modify(vo);
	}
	
	public SalaryVO getUserSalary(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateUserSalary(String id, SalaryVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
