package vo;

import java.util.Date;

public class ArrivalVO {
	String institutionID;
	Date date;
	String id;
	String departure;
	String condition;

	public ArrivalVO() {

	}

	public ArrivalVO(String institutionID, Date date, String id,
			String departure, String condition) {
		super();
		this.institutionID = institutionID;
		this.date = date;
		this.id = id;
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
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
