package po;

import java.util.Date;
import java.util.List;

/**
 * 装车单po
 * 
 * @author 王栋
 *
 */
public class EntruckPO {
	
	/**
	 * 装车时间
	 */
	private Date d;
	
	
	/**
	 * 本机构的编号
	 */
	private String institutionID;
	
	/**
	 * 汽运编号
	 */
	private String qyID;
	
	/**
	 * 到达地
	 */
	private String destination;
	
	/**
	 * 车辆代号
	 */
	private String truckID;

	/**
	 * 	检装员
	 */
	private String checkName;
	
	/**
	 * 押运员
	 */
	private String deliverMan;
	
    /**
     * 本次装车的所有ID  所有货物的订单条形码号
     */
	
	List<String>  IDlist;
	
	/**
	 * 本次运费
	 */
	double fare;

	public EntruckPO(Date d, String institutionID, String qyID,
			String destination, String truckID, String checkName,
			String deliverMan, List<String> iDlist, double fare) {
		super();
		this.d = d;
		this.institutionID = institutionID;
		this.qyID = qyID;
		this.destination = destination;
		this.truckID = truckID;
		this.checkName = checkName;
		this.deliverMan = deliverMan;
		IDlist = iDlist;
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

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getDeliverMan() {
		return deliverMan;
	}

	public void setDeliverMan(String deliverMan) {
		this.deliverMan = deliverMan;
	}

	public List<String> getIDlist() {
		return IDlist;
	}

	public void setIDlist(List<String> iDlist) {
		IDlist = iDlist;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	
	
}
