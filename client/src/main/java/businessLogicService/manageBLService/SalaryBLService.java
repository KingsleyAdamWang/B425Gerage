package businessLogicService.manageBLService;

public interface SalaryBLService {
	public SalaryVO getUserSalary(String id);
	
	public boolean updateUserSalary(String id,SalaryVO vo);
	
}
