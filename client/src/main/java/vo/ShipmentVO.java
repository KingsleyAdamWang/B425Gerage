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



	public String getId() {
		return id;
	}



	public Date getDate() {
		return date;
	}

	

	public String getDestination() {
		return destination;
	}


	public String getType() {
		return type;
	}



	public String getTransferID() {
		return transferID;
	}


}
