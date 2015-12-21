package businessLogic.financeBL;

import po.financePO.AccountPO;

public class MockAccountPO extends AccountPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MockAccountPO(String name, String accountID, double balance) {
		super(name, accountID, balance);
	}
}
