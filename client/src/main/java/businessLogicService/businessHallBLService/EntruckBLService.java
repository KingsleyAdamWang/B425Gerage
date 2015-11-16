package businessLogicService.businessHallBLService;

import vo.EntruckVO;

/**
 * 
 * 装车单操作的业务逻辑接口
 *
 */
public interface EntruckBLService {
	public String add(EntruckVO eVO);

	public  EntruckVO search(String id);

	/**
	 * 装车单提交
	 * @param vo
	 * @return
	 */
	public String submit(EntruckVO eVO);
	
	public String delete(EntruckVO eVO);
}
