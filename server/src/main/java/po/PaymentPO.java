package po;

import java.util.Date;

import enumSet.ReceiptsState;

//付款单的信息
public class PaymentPO extends ReceiptsPO{

	// 时间日期
	private Date d;
	
	// 付款金额
	private double amounts;
	
	// 付款人姓名
	private String name;
	
	// 付款的账号
	private String bankID;
	
	// 付款的种类 工资还是运费还是租金还是奖励
	private String type;
	// 备注
	private String comment;


	

	
	
	/**
	 * 付款单的构造函数
	 * @param state
	 * @param user
	 * @param d
	 * @param amounts
	 * @param name
	 * @param bankID
	 * @param type
	 * @param comment
	 */

	public PaymentPO(ReceiptsState state, UserPO user, Date d, double amounts,
			String name, String bankID, String type, String comment) {
		super(state, user);
		this.d = d;
		this.amounts = amounts;
		this.name = name;
		this.bankID = bankID;
		this.type = type;
		this.comment = comment;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public double getAmounts() {
		return amounts;
	}

	public void setAmounts(double amounts) {
		this.amounts = amounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
