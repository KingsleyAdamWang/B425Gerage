package vo;

import java.util.Date;
import java.util.Vector;

import po.ArrivalPO;
import util.DateUtil;
import enumSet.ArrivalState;
import enumSet.ReceiptsState;

/**
 * 达到单vo
 * @author 王栋
 *
 */
public class ArrivalVO extends Vector<String> {

	private static final long serialVersionUID = 1L;

	public ArrivalVO(ReceiptsState state, String userID, Date date,
			String institutionID, String transferId, String departure,
			ArrivalState condition) {
		this.add(state.getReceiptsStateString());
		this.add(userID);
		this.add(DateUtil.dateToString(date));
		this.add(institutionID);
		this.add(transferId);
		this.add(departure);
		this.add(condition.getStateString());

	}

	public ArrivalVO(String state, String userID, String date,
			String institutionID, String transferId, String departure,
			String condition) {

		this.add(state);
		this.add(userID);
		this.add(date);
		this.add(institutionID);
		this.add(transferId);
		this.add(departure);
		this.add(condition);
	}

	public ArrivalVO(ArrivalPO po) {
		this(po.getState(), po.getUserID(), po.getDate(),
				po.getInstitutionID(), po.getTransferId(), po.getDeparture(),
				po.getCondition());
	}

	public ArrivalPO transToPO() {
		return new ArrivalPO(ReceiptsState.getReceiptsState(get(0)), get(1),
				DateUtil.stringToDate(get(2)), get(3), get(4), get(5),
				ArrivalState.getArrivalState(get(6)));
	}

	public String getState() {
		return this.get(0);
	}

	public String getUserID() {
		return this.get(1);
	}

	public String getInstitutionID() {
		return this.get(3);
	}

	public String getDate() {
		return this.get(2);
	}

	public String getTransferId() {
		return this.get(4);
	}

	public String getDeparture() {
		return this.get(5);
	}

	public String getCondition() {
		return this.get(6);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.get(4) == null) ? 0 : this.get(4).hashCode());
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
		ArrivalVO other = (ArrivalVO) obj;
		if (this.get(4) == null) {
			if (other.get(4) != null)
				return false;
		} else if (!this.get(4).equals(other.get(4)))
			return false;
		return true;
	}

}
