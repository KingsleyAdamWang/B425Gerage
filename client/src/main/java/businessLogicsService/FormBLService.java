package businessLogicsService;

import java.util.Date;

import vo.CostVO;
import vo.RunVO;

/**
 * 报表操作的业务逻辑的相关接口
 * @author Kradness
 *
 */
public interface FormBLService {
	

	
	/**
	 * 传入起始时间申城对应的经营情况表
	 * @param start
	 * @param end
	 * @return 返回经营情况VO
	 */
	public RunVO checkRun(Date start , Date end);

	/**
	 * 查看成本收益表
	 * @return 截止到目前日期 也就是所有的收付款单据生成的成本收益VO
	 */
	public CostVO checkCost();
}
