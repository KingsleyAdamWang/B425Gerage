package vo;

import java.util.Date;

import po.PaymentPO;
import enumSet.ReceiptsState;

public class PaymentVO extends ReceiptsVO {
	// 付款日期
	public Date d;
	// 付款金額
	public double payment;
	// 付款人姓名
	public String payName;
	// 付款账号
	public String bankID;
	// 条目
	public String type;
	// 备注
	public String comment;
	// 次数 月份数
	public int times;

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

	public PaymentPO transToPO() {
		return new PaymentPO(state, userID, d, payment, payName, bankID, type,
				comment, times);
	}



}
