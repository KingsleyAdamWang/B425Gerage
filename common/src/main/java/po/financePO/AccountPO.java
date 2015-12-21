package po.financePO;

import java.io.Serializable;


/**
 * 银行账户PO
 * @author 王栋
 *
 */
public class AccountPO implements Serializable{



	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	
	private String name;
	private String accountID;
	private double balance;

	//想来想去还是不要加空的构造方法比较好 因为账户添加必须要这两条信息好不好
	

	


	public AccountPO(String name, String accountID, double balance) {
		super();
		this.name = name;
		this.accountID = accountID;
		this.balance = balance;
	}

	
	public String getAccountID() {
		return accountID;
	}


	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}


	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}



	//重写equal方法  由于余额不可修改 所以因此只需要通过name来进行比较
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountPO other = (AccountPO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
