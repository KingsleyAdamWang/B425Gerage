package vo;

import java.util.Date;

import po.ShipmentPO;
import enumSet.ReceiptsState;
import enumSet.TransportType;

public class ShipmentVO extends ReceiptsVO {
	String id;
	Date date;
	String institutionID, destination, type, transferID;

	public ShipmentVO(ReceiptsState state, String userID, String id, Date date,
			String institutionID, String destination, String type,
			String transferID) {
		super(state, userID);
		this.id = id;
		this.date = date;
		this.institutionID = institutionID;
		this.destination = destination;
		this.type = type;
		this.transferID = transferID;
	}

	public ShipmentVO(ShipmentPO po) {
		this(po.getState(), po.getUserID(), po.getId(), po.getDate(), po
				.getInstitutionID(), po.getDestination(), po.getType()
				.getTransportTypeString(), po.getTransferID());

	}

	public ShipmentPO transToPO() {
		return new ShipmentPO(state, transferID, institutionID, id, date,
				destination, transferID, TransportType.getTransportType(type));
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
		ShipmentVO other = (ShipmentVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
