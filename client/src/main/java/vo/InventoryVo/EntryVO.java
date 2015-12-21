package vo.InventoryVo;

import java.util.Date;

import po.inventoryPO.EntryPO;
import vo.ReceiptsVO;
import enumSet.InventoryArea;
import enumSet.ReceiptsState;

public class EntryVO extends ReceiptsVO {
	public String id;
	public String institutionID;
	public Date date;
	public String destination;
	public int row, shelf, place;
	public InventoryArea area;

	public EntryVO(ReceiptsState state, String userID, String id,
			String institutionID, Date date, String destination, int row,
			int shelf, int place, InventoryArea area) {
		super(state, userID);
		this.id = id;
		this.date = date;
		this.institutionID = institutionID;
		this.destination = destination;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
	}

	public EntryVO(EntryPO po) {
		this(po.getState(), po.getUserID(), po.getId(), po.getInstitutionID(),
				po.getDate(), po.getDestination(), po.getRow(), po.getShelf(),
				po.getPlace(), po.getArea());

	}

	public EntryPO transToPO() {
		return new EntryPO(state, userID, id, institutionID, date, destination,
				row, shelf, place, area);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result
				+ ((institutionID == null) ? 0 : institutionID.hashCode());
		result = prime * result + place;
		result = prime * result + row;
		result = prime * result + shelf;
		return result;
	}

	public String getInstitutionID() {
		return institutionID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntryVO other = (EntryVO) obj;
		if (area != other.area)
			return false;
		if (institutionID == null) {
			if (other.institutionID != null)
				return false;
		} else if (!institutionID.equals(other.institutionID))
			return false;
		if (place != other.place)
			return false;
		if (row != other.row)
			return false;
		if (shelf != other.shelf)
			return false;
		return true;
	}

	

}
