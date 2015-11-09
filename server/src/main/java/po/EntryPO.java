package po;

import java.util.Date;

import enumSet.InventoryArea;
import enumSet.ReceiptsState;

/**
 * 入库单的po
 * @author 王栋
 *
 */
public class EntryPO extends ReceiptsPO{
	
	

	//入库单的编号
	private String id;
	
	//时间
	private Date date;
	
	//目的地（本快递的）
	private String destination;
	
	//  排 架 位
	private int row, shelf, place;
	// 区
	private InventoryArea area;

	


	public EntryPO(ReceiptsState state, UserPO user, String id, Date date,
			String destination, int row, int shelf, int place,
			InventoryArea area) {
		super(state, user);
		this.id = id;
		this.date = date;
		this.destination = destination;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
		this.area = area;
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

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getShelf() {
		return shelf;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public InventoryArea getArea() {
		return area;
	}

	public void setArea(InventoryArea area) {
		this.area = area;
	}





	
}
