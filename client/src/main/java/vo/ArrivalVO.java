package vo;

import java.util.Date;

import po.ArrivalPO;
import enumSet.ArrivalState;
import enumSet.ReceiptsState;

public class ArrivalVO extends ReceiptsVO {
	Date date;
	String transferId;
	String departure;
	ArrivalState condition;
	String institutionID;

	public ArrivalVO(ReceiptsState state, String userID, Date date,
			String institutionID,String transferId, String departure, ArrivalState condition) {
		super(state, userID);
		this.date = date;
		this.transferId = transferId;
		this.departure = departure;
		this.condition = condition;
		this.institutionID = institutionID;
	}

	public ArrivalVO(ArrivalPO po) {
		this(po.getState(), po.getUserID(), po.getDate(), po.getInstitutionID(),po.getTransferId(),
				po.getDeparture(), po.getCondition());
	}

	public ArrivalPO transToPO() {
		return new ArrivalPO(this.state, this.userID, this.date,
				this.institutionID,this.transferId, this.departure, this.condition);
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return transferId;
	}

	public void setId(String id) {
		this.transferId = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public ArrivalState getCondition() {
		return condition;
	}

	public void setCondition(ArrivalState condition) {
		this.condition = condition;
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
		ArrivalVO other = (ArrivalVO) obj;
		if (transferId == null) {
			if (other.transferId != null)
				return false;
		} else if (!transferId.equals(other.transferId))
			return false;
		return true;
	}

	
	
}
