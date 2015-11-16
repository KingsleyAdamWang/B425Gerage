package businessLogic.financeBL;

import po.AccountPO;

public class MockAccountPO extends AccountPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MockAccountPO(String name, String accountID, double balance) {
		super(name, accountID, balance);
	}
}
