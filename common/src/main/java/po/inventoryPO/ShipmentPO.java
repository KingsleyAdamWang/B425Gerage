package po.inventoryPO;

import java.io.Serializable;
import java.util.Date;

import po.ReceiptsPO;
import util.DateUtil;
import enumSet.ReceiptsState;
import enumSet.TransportType;

public class ShipmentPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 填写该出库单的中转中心的编号
	private String institutionID;
	// 快递单号
	private String id;
	// 日期
	private Date date;
	// 目的地
	private String destination;
	// 中转单编号
	private String transferID;
	// 中转的运输类型
	private TransportType type;

	/**
	 * 出库单填写po
	 * 
	 * @param user
	 */

	public ShipmentPO(String data) {
		String[] temp = data.split(" ");
		this.state = ReceiptsState.getReceiptsState(temp[0]);
		this.userID = temp[1];
		this.institutionID = temp[2];
		this.id = temp[3];
		this.date = DateUtil.stringToDate(temp[4]);
		this.destination = temp[5];
		this.transferID = temp[6];
		this.type = TransportType.getTransportType(temp[7]);

	}

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

	public String toString() {
		return state.getReceiptsStateString() + " " + userID + " "
				+ institutionID + " " + id + " " + DateUtil.dateToString(date)
				+ " " + destination + " " + transferID + " "
				+ type.getTransportTypeString() + "\n";
	}

	public String getInstitutionID() {
		return institutionID;
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

	public String getTransferID() {
		return transferID;
	}

	public TransportType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipmentPO other = (ShipmentPO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
