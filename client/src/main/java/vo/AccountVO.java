package vo;

import java.util.Vector;

import po.AccountPO;

public class AccountVO extends Vector<String> {

	private static final long serialVersionUID = 1L;

	public AccountVO(AccountPO po){
		this(po.getName(),po.getAccountID(),po.getBalance());
	}
	/**
	 * 构造方法
	 * 
	 * @param name
	 * @param accountID
//	 * @param balance
	 */
	public AccountVO(String name, String accountID, double balance) {
		this.add(name);
		this.add(accountID);
		this.add(balance + "");
	}

	// 将AccountVO转化为AccountPO
	public AccountPO transToPO() {
		return new AccountPO(this.get(0), this.get(1), Double.parseDouble(this
				.get(2)));
	}

	public String getAccountID() {
		return this.get(1);
	}

	public String getName() {
		return this.get(0);
	}

	public double getBalance() {
		return Double.parseDouble(this.get(2));
	}

	// 重写equal方法 由于余额不可修改 所以因此只需要通过name来进行比较
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountVO other = (AccountVO) obj;
		if (this.get(0) == null) {
			if (other.get(0) != null)
				return false;
		} else if (this.get(0).equals(other.get(0)))
			return false;
		return true;
	}
	


}
