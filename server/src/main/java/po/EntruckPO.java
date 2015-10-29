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
	 * 车辆的信息的PO 通过根据输入的truck的编号查询List<TruckPO>获得
	 */
	TruckPO  truckPO;
	
    /**
     * 本次装车的所有ID  所有货物的订单条形码号
     */
	
	List<String>  IDlist;
	
	/**
	 * 本次运费
	 */
	double fare;

	/**
	 * 构造方法
	 * @param d
	 * @param institutionID
	 * @param qyID
	 * @param destination
	 * @param truckPO
	 * @param iDlist
	 * @param fare
	 */
	public EntruckPO(Date d, String institutionID, String qyID,
			String destination, TruckPO truckPO, List<String> iDlist,
			double fare) {
		super();
		this.d = d;
		this.institutionID = institutionID;
		this.qyID = qyID;
		this.destination = destination;
		this.truckPO = truckPO;
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

	public TruckPO getTruckPO() {
		return truckPO;
	}

	public void setTruckPO(TruckPO truckPO) {
		this.truckPO = truckPO;
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
