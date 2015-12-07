package po;

import java.io.Serializable;
import java.util.Date;

import util.DateUtil;
import enumSet.ReceiptsState;

public class ReceivePO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 快递单号
	private String id;
	// 收件人的姓名
	private String name;
	// 收件人的电话号码
	private String telNum;
	// 日期
	private Date d;

	// 构造方法
	public ReceivePO(ReceiptsState state, String userID, String id,
			String name, String telNum, Date d) {
		super(state, userID);
		this.id = id;
		this.name = name;
		this.telNum = telNum;
		this.d = d;
	}

	public ReceivePO(String data) {
		String temp[] = data.split(" ");
		state = ReceiptsState.getReceiptsState(temp[0]);
		userID = temp[1];
		id = temp[2];
		name = temp[3];
		telNum = temp[4];
		d = DateUtil.stringToDate(temp[5]);

	}

	public String toString() {
		return state.getReceiptsStateString() + " " + userID + " " + id + " "
				+ name + " " + telNum + " " + DateUtil.dateToString(d) + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getD() {
		return d;
	}

	public String getTelNum() {
		return telNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceivePO other = (ReceivePO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
