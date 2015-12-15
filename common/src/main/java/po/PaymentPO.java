package po;

import java.io.Serializable;
import java.util.Date;

import util.DateUtil;
import enumSet.ReceiptsState;

//付款单的信息
public class PaymentPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

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
	public PaymentPO(ReceiptsState state, String userID, Date d,
			double ammounts, String name, String bankID, String type,
			String comment, int times) {
		super(state, userID);
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
		d = DateUtil.stringToDate(temp[2]);
		ammounts = Double.parseDouble(temp[3]);
		name = temp[4];
	    bankID = temp[5];
		type = temp[6];
		comment = temp[7];
		times = Integer.parseInt(temp[8]);
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(state.getReceiptsStateString() + " " + userID + " "
				+ DateUtil.dateToString(d) + " " + ammounts + " " + name + " "
				+ bankID + " " + type + " " + comment + " " + times + "\n");
		return str.toString();
	}

	public Date getD() {
		return d;
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
	
	public void setComment(String comment){
		this.comment=comment;
	}

}
