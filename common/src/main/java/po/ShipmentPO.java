package po;

import java.io.Serializable;
import java.util.Date;

import enumSet.ReceiptsState;
import enumSet.TransportType;

public class ShipmentPO extends ReceiptsPO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//填写该出库单的中转中心的编号
	private String institutionID;
	//快递单号
	private String id;
	//日期
	private Date date;
    //目的地
	private String destination;
	//中转单编号
	private String transferID;
	//中转的运输类型
	private  TransportType type;

	
	/**
	 * 出库单填写po
	 * @param state
	 * @param user
	 * @param institutionID
	 * @param id
	 * @param date
	 * @param destination
	 * @param transferID
	 * @param type
	 */
	
	
	public ShipmentPO(ReceiptsState state, String userID, String institutionID,
			String id, Date date, String destination, String transferID,
			TransportType type) {
		super(state, userID);
		this.institutionID = institutionID;
		this.id = id;
		this.date = date;
		this.destination = destination;
		this.transferID = transferID;
		this.type = type;
	}
	public String getInstitutionID() {
		return institutionID;
	}
	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTransferID() {
		return transferID;
	}
	public void setTransferID(String transferID) {
		this.transferID = transferID;
	}
	public TransportType getType() {
		return type;
	}
	public void setType(TransportType type) {
		this.type = type;
	}
	
	
	
	

}
