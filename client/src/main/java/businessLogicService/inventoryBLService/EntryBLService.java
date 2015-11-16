package businessLogicService.inventoryBLService;

import vo.EntryVO;

/**
 * 入库单的业务逻辑操作相关接口
 * @author Kradness
 *
 */
public interface EntryBLService {
	
	/**
	 * 入库单提交
	 * @param vo
	 * @return
	 */
	public boolean submitEntry(EntryVO eVO);
}
