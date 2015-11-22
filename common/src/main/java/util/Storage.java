package util;

public class Storage {
   private int row;
   private int shelf;
   private int place;
   
   
public Storage(int row, int shelf, int place) {
	super();
	this.row = row;
	this.shelf = shelf;
	this.place = place;
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
