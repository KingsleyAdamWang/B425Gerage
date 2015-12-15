package po;

import java.io.Serializable;
import java.util.Date;

import util.DateUtil;

public class TruckPO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String institutionID;
	//车的编号
	private String truckID ;
	//车牌号
	private String truckNumber;
	//服役时间
	private Date startTime;
	
	
	
	public String getTruckID() {
		return truckID;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	
	public String getInstitutionID() {
		return institutionID;
	}

	public Date getStartTime() {
		return startTime;
	}

	public TruckPO(String institutionID,String truckID, String truckNumber, Date years) {
		super();
		this.institutionID = institutionID;
		this.truckID = truckID;
		this.truckNumber = truckNumber;
		this.startTime = years;
	}
	
	public TruckPO(String data){
		String strs[] = data.split(" ");
		this.institutionID = strs[0];
		this.truckID = strs[1];
		this.truckNumber = strs[2];
		this.startTime = DateUtil.stringToDate(strs[3]);
	}
	
	public String toString(){
		return this.institutionID+" "+this.truckID + " " + this.truckNumber + " " + DateUtil.dateToString(startTime)+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((truckNumber == null) ? 0 : truckNumber.hashCode());
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
		TruckPO other = (TruckPO) obj;
		if (truckNumber == null) {
			if (other.truckNumber != null)
				return false;
		} else if (!truckNumber.equals(other.truckNumber))
			return false;
		return true;
	}

}
