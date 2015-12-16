package po;

import java.io.Serializable;
import java.util.Date;

import util.DateUtil;
import enumSet.ReceiptsState;

//付款单的信息
public class PaymentPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	//付款单id
	private String payID;
	
	// 时间日期
	private Date d;

	// 付款金额
	private double ammounts;

	// 付款人姓名
	private String name;

	// 付款的账号
	private String bankID;

	// 付款的种类 工资还是运费还是租金还是奖励
	private String type;
	// 备注
	private String comment;

	// 付款的月数 次数
	private int times;

	/**
	 * 付款单的构造函数
	 * 
	 * @param state
	 * @param user
	 * @param d
	 * @param amounts
	 * @param name
	 * @param bankID
	 * @param type
	 * @param comment
	 */

	/*
	 * 付款单的构造方法
	 */
	public PaymentPO(ReceiptsState state, String userID,String payID, Date d,
			double ammounts, String name, String bankID, String type,
			String comment, int times) {
		super(state, userID);
		this.payID = payID;
		this.d = d;
		this.ammounts = ammounts;
		this.name = name;
		this.bankID = bankID;
		this.type = type;
		this.comment = comment;
		this.times = times;
		// this.fare = fare;
	}

	public PaymentPO(String data) {
		String[] temp = data.split(" ");
		state = ReceiptsState.getReceiptsState(temp[0]);
		userID = temp[1];
		payID = temp[2];
		d = DateUtil.stringToDate(temp[3]);
		ammounts = Double.parseDouble(temp[4]);
		name = temp[5];
	    bankID = temp[6];
		type = temp[7];
		comment = temp[8];
		times = Integer.parseInt(temp[9]);
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(state.getReceiptsStateString() + " " + userID + " "
				+payID+ DateUtil.dateToString(d) + " " + ammounts + " " + name + " "
				+ bankID + " " + type + " " + comment + " " + times + "\n");
		return str.toString();
	}

	public Date getD() {
		return d;
	}
	public String getPayID(){
		return payID;
	}

	public double getAmmounts() {
		return ammounts;
	}

	public String getName() {
		return name;
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

	public int getTimes() {
		return times;
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
		PaymentPO other = (PaymentPO) obj;
		if (payID == null) {
			if (other.payID != null)
				return false;
		} else if (!payID.equals(other.payID))
			return false;
		return true;
	}
	
}
