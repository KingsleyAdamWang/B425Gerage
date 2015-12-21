package po.businessPO;

import java.io.Serializable;
import java.util.Date;

import po.ReceiptsPO;
import util.DateUtil;
import enumSet.ArrivalState;
import enumSet.ReceiptsState;

/**
 * 到达单PO
 * 
 * @author 王栋
 *
 */
public class ArrivalPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 到达日期
	 */
	private Date date;

	private String institutionID;
	/**
	 * 中转单单号
	 */
	private String transferId;
	/**
	 * 出发地
	 */
	private String departure;
	/**
	 * 到达状态
	 */
	private ArrivalState condition;

	/**
	 * 
	 * @param state
	 *            状态 ： 审批未审批
	 * @param userID
	 *            操作的用户
	 * @param date
	 *            时间
	 * @param transferId
	 *            中转单单号
	 * @param departure
	 *            出发地址
	 * @param condition
	 *            到达状态
	 */

	public String getTransferId() {
		return transferId;
	}

	public ArrivalPO(ReceiptsState state, String userID, Date date,
			String institutionID, String transferId, String departure,
			ArrivalState condition) {
		super(state, userID);
		this.date = date;
		this.institutionID = institutionID;
		this.transferId = transferId;
		this.departure = departure;
		this.condition = condition;
	}

	public ArrivalPO(String data) {
		String temp[] = data.split(" ");
		state = ReceiptsState.getReceiptsState(temp[0]);
		userID = temp[1];
		date = DateUtil.stringToDate(temp[2]);
		institutionID = temp[3];
		transferId = temp[4];
		departure = temp[5];
		condition = ArrivalState.getArrivalState(temp[6]);
	}

	public String toString() {

		return state.getReceiptsStateString() + " " + userID + " "
				+ DateUtil.dateToString(date) + " " + institutionID + " "
				+ transferId + " " + departure + " "
				+ condition.getStateString() + "\n";
	}

	public ReceiptsState getState() {
		return state;
	}

	public Date getDate() {
		return date;
	}

	public String getDeparture() {
		return departure;
	}

	public ArrivalState getCondition() {
		return condition;
	}
	
	

	public String getInstitutionID() {
		return institutionID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((transferId == null) ? 0 : transferId.hashCode());
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
		ArrivalPO other = (ArrivalPO) obj;
		if (transferId == null) {
			if (other.transferId != null)
				return false;
		} else if (!transferId.equals(other.transferId))
			return false;
		return true;
	}

}
