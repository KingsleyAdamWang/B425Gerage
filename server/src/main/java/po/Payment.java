package po;

import java.util.Date;

//付款单的信息
public class Payment {

	// 时间日期
	private Date d;
	// 付款金额
	private double amounts;
	// 付款人姓名
	private String name;
	// 付款的账号
	private String bankID;
	// 付款的种类 工资还是运费还是租金还是奖励
	private String Type;
	// 备注
	private String comment;

	public Payment(Date d, double amounts, String name, String bankID,
			String type, String comment) {
		super();
		this.d = d;
		this.amounts = amounts;
		this.name = name;
		this.bankID = bankID;
		Type = type;
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
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
