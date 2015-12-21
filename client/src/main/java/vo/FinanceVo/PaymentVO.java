package vo.FinanceVo;

import java.util.Date;

import po.PaymentPO;
import vo.ReceiptsVO;
import enumSet.ReceiptsState;

public class PaymentVO extends ReceiptsVO {

	public String payID;
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

	public PaymentVO(ReceiptsState state, String userID, String payID, Date d,
			double payment, String payName, String bankID, String type,
			String comment, int times) {
		super(state, userID);
		this.d = d;
		this.payID = payID;
		this.payment = payment;
		this.payName = payName;
		this.bankID = bankID;
		this.type = type;
		this.comment = comment;
		this.times = times;
	}

	public PaymentVO(PaymentPO po) {
		this(po.getState(), po.getUserID(), po.getPayID(), po.getD(), po
				.getAmmounts(), po.getName(), po.getBankID(), po.getType(), po
				.getComment(), po.getTimes());
	}

	public PaymentPO transToPO() {
		return new PaymentPO(state, userID, payID, d, payment, payName, bankID,
				type, comment, times);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payID == null) ? 0 : payID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentVO other = (PaymentVO) obj;
		if (payID == null) {
			if (other.payID != null)
				return false;
		} else if (!payID.equals(other.payID))
			return false;
		return true;
	}
}
