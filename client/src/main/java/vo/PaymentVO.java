package vo;

import java.util.Date;

public class PaymentVO {
	// 付款日期
	Date d;
	// 付款金額
	double payment;
	// 付款人姓名
	String payName;
	// 付款账号
	String bankID;
	// 条目
	String content;
	// 备注
	String comment;

	public PaymentVO(Date d, double payment, String payName, String bankID,
			String content, String comment) {
		super();
		this.d = d;
		this.payment = payment;
		this.payName = payName;
		this.bankID = bankID;
		this.content = content;
		this.comment = comment;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
