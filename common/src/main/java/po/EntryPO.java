package po;

import java.io.Serializable;
import java.util.Date;

import util.DateUtil;
import enumSet.InventoryArea;
import enumSet.ReceiptsState;

/**
 * 入库单的po
 * 
 * @author 王栋
 *
 */
public class EntryPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 入库单的编号 即快递编号
	private String id;

	private String institutionID;

	// 时间
	private Date date;

	// 目的地（本快递的）
	private String destination;

	// 排 架 位
	private int row, shelf, place;
	// 区
	private InventoryArea area;

	public EntryPO(ReceiptsState state, String userID, String id,
			String institutionID, Date date, String destination, int row,
			int shelf, int place, InventoryArea area) {
		super(state, userID);
		this.id = id;
		this.institutionID = institutionID;
		this.date = date;
		this.destination = destination;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
		this.area = area;
	}

	public EntryPO(String data) {
		String[] temp = data.split(" ");
		this.state = ReceiptsState.getReceiptsState(temp[0]);
		this.userID = temp[1];
		this.id = temp[2];
		this.institutionID = temp[3];
		this.date = DateUtil.stringToDate(temp[4]);
		this.destination = temp[5];
		this.row = Integer.parseInt(temp[6]);
		this.shelf = Integer.parseInt(temp[7]);
		this.place = Integer.parseInt(temp[8]);
		this.area = InventoryArea.getInventoryArea(temp[9]);

	}

	public String toString() {
		return state.getReceiptsStateString() + " " + userID + " " + id + " "
				+ institutionID + " " + DateUtil.dateToString(date) + " "
				+ destination + " " + row + " " + shelf + "　" + place + " "
				+ area.getAreaString() + "\n";
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

	public int getRow() {
		return row;
	}

	public int getShelf() {
		return shelf;
	}

	public int getPlace() {
		return place;
	}

	public InventoryArea getArea() {
		return area;
	}

	public String getInstitutionID() {
		return institutionID;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntryPO other = (EntryPO) obj;
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
