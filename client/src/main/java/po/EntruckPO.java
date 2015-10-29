package po;

import java.util.Date;
import java.util.List;

import vo.DriverVO;
import vo.UserVO;

public class EntruckPO {
	Date d;
	String institutionID, qyID, destination, truckID;
	UserVO user;
	DriverVO driver;
	List<String> list;
	double fare;

	public EntruckPO() {

	}

	public EntruckPO(Date d, String institutionID, String qyID,
			String destination, String truckID, UserVO user, DriverVO driver,
			List<String> list, double fare) {
		super();
		this.d = d;
		this.institutionID = institutionID;
		this.qyID = qyID;
		this.destination = destination;
		this.truckID = truckID;
		this.user = user;
		this.driver = driver;
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

	public String getQyID() {
		return qyID;
	}

	public void setQyID(String qyID) {
		this.qyID = qyID;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTruckID() {
		return truckID;
	}

	public void setTruckID(String truckID) {
		this.truckID = truckID;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public DriverVO getDriver() {
		return driver;
	}

	public void setDriver(DriverVO driver) {
		this.driver = driver;
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
