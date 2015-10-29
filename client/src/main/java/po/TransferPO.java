package po;

import java.util.Date;
import java.util.List;

import vo.UserVO;

public class TransferPO {
	Date d;
	String institutionID, hangbanID, departure, destination, counterID;
	UserVO user;
	List<String> list;
	double fare;

	public TransferPO() {

	}

	public TransferPO(Date d, String institutionID, String hangbanID,
			String departure, String destination, String counterID,
			UserVO user, List<String> list, double fare) {
		super();
		this.d = d;
		this.institutionID = institutionID;
		this.hangbanID = hangbanID;
		this.departure = departure;
		this.destination = destination;
		this.counterID = counterID;
		this.user = user;
		this.list = list;
		this.fare = fare;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}

	public String getHangbanID() {
		return hangbanID;
	}

	public void setHangbanID(String hangbanID) {
		this.hangbanID = hangbanID;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCounterID() {
		return counterID;
	}

	public void setCounterID(String counterID) {
		this.counterID = counterID;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}
}
