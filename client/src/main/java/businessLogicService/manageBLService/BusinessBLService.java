package businessLogicService.manageBLService;

public interface BusinessBLService {
	public BusinessStrategyVO getBusinessStrategy();
	
	public boolean updateUserSalary(BusinessStrategyVO vo);
	
}
