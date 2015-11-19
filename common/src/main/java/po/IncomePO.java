package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DateUtil;
import enumSet.ReceiptsState;

public class IncomePO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date;
	private double income;
	private String kdyID;
	private List<String> idList;

	/**
	 * 构造函数
	 * 
	 * @param state
	 * @param userID
	 * @param date
	 * @param income
	 * @param kdyID
	 * @param idList
	 */
	public IncomePO(ReceiptsState state, String userID, Date date,
			double income, String kdyID, List<String> idList) {
		super(state, userID);
		this.date = date;
		this.income = income;
		this.kdyID = kdyID;
		this.idList = idList;
	}

	/**
	 * 从txt中读取文件获得信息 生成对应的PO
	 * 
	 * @param data
	 */
	public IncomePO(String data) {
		idList = new ArrayList<String>();
		String temp[] = data.split(" ");
		if (temp.length == 5) {
			this.state = ReceiptsState.getReceiptsState(temp[0]);
			this.userID = temp[1];
			this.date = DateUtil.stringToDate(temp[2]);
			this.income = Double.parseDouble(temp[3]);
			for (String str : temp[4].split(";"))
				idList.add(str);
		}
	}

	/**
	 * 将该po对象变为String 便于存储到Txt中去
	 */
	public String toString() {
		// 将po对象转化为对应的字符串便于储存读取
		String temp = "";
		for (String str : idList)
			temp += (str + ";");
		return this.state.getReceiptsStateString() + " " + this.userID + " "
				+ DateUtil.dateToString(this.date) + " " + this.kdyID + " "
				+ this.income + " " + temp + "\n";
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getKdyID() {
		return kdyID;
	}

	public void setKdyID(String kdyID) {
		this.kdyID = kdyID;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

}
