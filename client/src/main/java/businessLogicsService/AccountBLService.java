package businessLogicsService;

import java.util.List;

import vo.AccountVO;

/**
 * 
 * 实现银行账户操作的相关业务逻辑的接口
 *
 */
public interface AccountBLService {
	
	/**
	 * 增
	 * @param name
	 * @param balance
	 */
	public void add(String name,double balance);
	
	/**
	 * 改
	 * @param vo
	 * @param name
	 */
	public void modify(AccountVO vo,String name);
	
	/**
	 * 删
	 * @param vo
	 */
	public void delete(AccountVO vo);
	
	/**
	 * 查
	 * @param key
	 * @return
	 */
	public  List<AccountVO> check(String key);

}
