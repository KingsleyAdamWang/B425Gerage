package po;

import java.util.Date;

/**
 * 到达单PO
 * @author 王栋
 *
 */
public class ArrivalPO {
	/**
	 * 到达机构的编号
	 */
	private String institutionID;
	/**
	 * 到达日期
	 */
	Date date;
	/**
	 * 中转单单号
	 */
	String transferId;
	/**
	 * 出发地
	 */
	String departure;
	/**
	 * 到达状态
	 */
	ArrivalState condition;

	public ArrivalPO() {

	}

	/**
	 * 构造方法
	 * @param institutionID
	 * @param date
	 * @param transferId
	 * @param departure
	 * @param condition
	 */
	public ArrivalPO(String institutionID, Date date, String transferId,
			String departure, ArrivalState condition) {
		super();
		this.institutionID = institutionID;
		this.date = date;
		this.transferId = transferId;
		this.departure = departure;
		this.condition = condition;
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
		return institutionID;
	}

	public void setId(String id) {
		this.institutionID = id;
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

}
