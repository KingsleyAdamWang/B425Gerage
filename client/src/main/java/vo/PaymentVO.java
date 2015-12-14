package vo;

import java.util.Date;

import po.PaymentPO;
import enumSet.ReceiptsState;

public class PaymentVO extends ReceiptsVO {
	// 付款日期
	Date d;
	// 付款金額
	double payment;
	// 付款人姓名
	String payName;
	// 付款账号
	String bankID;
	// 条目
	String type;
	// 备注
	String comment;
	// 次数 月份数
	int times;

	public PaymentVO(ReceiptsState state, String userID, Date d,
			double payment, String payName, String bankID, String type,
			String comment, int times) {
		super(state, userID);
		this.d = d;
		this.payment = payment;
		this.payName = payName;
		this.bankID = bankID;
		this.type = type;
		this.comment = comment;
		this.times = times;
	}

	public PaymentVO(PaymentPO po) {
		this(po.getState(), po.getUserID(), po.getD(), po.getAmmounts(), po
				.getName(), po.getBankID(), po.getType(), po.getComment(), po
				.getTimes());
	}

	public Date getD() {
		return d;
	}

	public double getPayment() {
		return payment;
	}

	public String getPayName() {
		return payName;
	}

	public String getBankID() {
		return bankID;
	}

	public String getType() {
		return type;
	}

	public String getComment() {
		return comment;
	}

}
