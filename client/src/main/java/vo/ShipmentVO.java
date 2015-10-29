package vo;

import java.util.Date;

public class ShipmentVO {
	String id;
	Date date;
	String destination, type, transferID;

	public ShipmentVO(String id, Date date, String destination, String type,
			String transferID) {
		super();
		this.id = id;
		this.date = date;
		this.destination = destination;
		this.type = type;
		this.transferID = transferID;
	}

	public ShipmentVO() {
		// TODO Auto-generated constructor stub
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransferID() {
		return transferID;
	}

	public void setTransferID(String transferID) {
		this.transferID = transferID;
	}

}
