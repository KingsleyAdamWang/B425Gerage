package businessLogicService.businessHallBLService;

import vo.ArrivalVO;

/**
 * 
 * 实现到达单操作的业务逻辑接口
 *
 */
public interface ArrivalBLService {
	
	public String add(ArrivalVO arrivalVO);

	public ArrivalVO search(String id);

	public String delete(ArrivalVO arrivalVO) ;
	
}
