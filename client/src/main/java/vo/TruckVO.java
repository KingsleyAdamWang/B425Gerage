package vo;

import java.util.Date;

import po.TruckPO;
import util.DateUtil;

public class TruckVO {
	public String institutionID;
	// 车的编号
	public  String truckID;
	// 车牌号
	public  String truckNumber;
	// 开始服役时间
	public Date startTime;
	//
	public int years;

	public TruckVO(String institutionID,String truckID, String truckNumber, Date startTime) {
		// TODO 自动生成的构造函数存根
		this.institutionID = institutionID;
		this.truckID = truckID;
		this.truckNumber = truckNumber;
		this.startTime = startTime;
		this.years=getYears(startTime);
	}
	
	public TruckVO(TruckPO po){
		this(po.getInstitutionID(),po.getTruckID(),po.getTruckNumber(),po.getStartTime());
	}
	/**
	 * vo转po
	 */
	public TruckPO transToPO(){
		return new TruckPO(institutionID,truckID,truckNumber,startTime);
	}
	public int getYears(Date startTime){
		Date  date = DateUtil.stringToDate(DateUtil.dateToString());
		return date.getYear()-startTime.getYear();
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
		TruckVO other = (TruckVO) obj;
		if (truckNumber == null) {
			if (other.truckNumber != null)
				return false;
		} else if (!truckNumber.equals(other.truckNumber))
			return false;
		return true;
	}




}
