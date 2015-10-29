package po;

/**
 * 银行账户PO
 * @author 王栋
 *
 */
public class AccountPO {
	private String name;
	private double balance;

	//想来想去还是不要加空的构造方法比较好 因为账户添加必须要这两条信息好不好
	
	public AccountPO(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
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

}
