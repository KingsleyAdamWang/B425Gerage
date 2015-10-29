package po;

import java.util.Date;

public class EntryPO {
	String id;
	Date date;
	String destination;
	int area, row, shelf, place;

	public EntryPO() {

	}

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
