package po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import enumSet.ReceiptsState;
import enumSet.TransportType;

public class TransferPO extends ReceiptsPO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	//时间
	private Date d;
	//机构编号
	private String institutionID;
	//中转中心的货运编号/航空编号
	private String transferID;
	//出发地城市
	private String departure;
	//目的地城市
	private String destination;
	//该中转单所具有的所有物流的快递单号
	private List<String> list;
	//中转产生的运费
	private double fare;
	//中转的类型 飞机 火车 还是汽车
	private TransportType type;
	//检装员
	private String name ;
	//根据类型不同 飞机是货柜号 火车是车厢号 汽车是押运员
	private String temp;
	
	
	
	
	
	/**
	 * 中转单的构造函数
	 * @param state
	 * @param user
	 * @param d
	 * @param institutionID
	 * @param transferID
	 * @param departure
	 * @param destination
	 * @param list
	 * @param fare
	 * @param type
	 * @param name
	 * @param temp
	 */
	public TransferPO(ReceiptsState state, String userID, Date d,
			String institutionID, String transferID, String departure,
			String destination, List<String> list, double fare,
			TransportType type, String name, String temp) {
		super(state, userID);
		this.d = d;
		this.institutionID = institutionID;
		this.transferID = transferID;
		this.departure = departure;
		this.destination = destination;
		this.list = list;
		this.fare = fare;
		this.type = type;
		this.name = name;
		this.temp = temp;
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
	public String getTransferID() {
		return transferID;
	}
	public void setTransferID(String transferID) {
		this.transferID = transferID;
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
	public TransportType getType() {
		return type;
	}
	public void setType(TransportType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	
	
	
}
