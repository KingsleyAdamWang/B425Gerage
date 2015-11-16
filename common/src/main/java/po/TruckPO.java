package po;

import java.io.Serializable;

public class TruckPO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//车的编号
	private String truckID ;
	//车牌号
	private String truckNumber;
	//服役时间
	private int years;
	
	
	
	public String getTruckID() {
		return truckID;
	}
	public void setTruckID(String truckID) {
		this.truckID = truckID;
	}
	public String getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	
	
	public TruckPO(String truckID, String truckNumber, int years) {
		super();
		this.truckID = truckID;
		this.truckNumber = truckNumber;
		this.years = years;
	}
	
	

}
