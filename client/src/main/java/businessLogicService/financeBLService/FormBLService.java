package businessLogicService.financeBLService;

import java.util.Date;

import vo.CostVO;
import vo.RunVO;

/**
 * 报表操作的业务逻辑的相关接口
 * @author Kradness
 *
 */
public interface FormBLService {
	
	
	public void exportCostForm();
	public void exportRunForm(Date start,Date end);
	
}
