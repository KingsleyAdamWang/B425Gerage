package po;

import java.util.Date;

/**
 * 入库单的po
 * @author 王栋
 *
 */
public class EntryPO {
	//入库单的编号
	private String id;
	//时间
	Date date;
	//目的地（本快递的）
	String destination;
	
	// 区 排 架 位
	int area, row, shelf, place;


	public EntryPO(String id, Date date, String destination, int area, int row,
			int shelf, int place) {
		super();
		this.id = id;
		this.date = date;
		this.destination = destination;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
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

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
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
}
