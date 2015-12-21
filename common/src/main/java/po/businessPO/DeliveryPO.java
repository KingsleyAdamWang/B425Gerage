package po.businessPO;

import java.io.Serializable;
import java.util.Date;

import po.ReceiptsPO;
import util.DateUtil;
import enumSet.ReceiptsState;

/**
 * 派件单PO
 * 
 * @author 王栋
 *
 */
public class DeliveryPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 时间对象到达日期
	 */
	private Date d;
	/**
	 * 派件单所派送的货物的快递单号
	 */
	private String id;
	/**
	 * 派送员姓名
	 */
	private String name;

	/**
	 * 构造函数
	 * 
	 * @param state
	 * @param user
	 * @param d
	 * @param id
	 * @param name
	 */
	public DeliveryPO(ReceiptsState state, String userID, Date d, String id,
			String name) {
		super(state, userID);
		this.d = d;
		this.id = id;
		this.name = name;
	}

	public DeliveryPO(String data) {
		String temp[] = data.split(" ");
		state = ReceiptsState.getReceiptsState(temp[0]);
		userID = temp[1];
		d = DateUtil.stringToDate(temp[2]);
		id = temp[3];
		name = temp[4];
	}

	public String toString() {
		return state.getReceiptsStateString() + " " + userID + " "
				+ DateUtil.dateToString(d) + " " + id + " " + name + "\n";
	}

	public Date getD() {
		return d;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DeliveryPO other = (DeliveryPO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
