package vo;

import java.util.Date;

import po.TruckPO;

public class TruckVO {
	// 车的编号
	 String truckID;
	// 车牌号
	 String truckNumber;
	// 开始服役时间
	Date years;

	public TruckVO(String truckID, String truckNumber, Date years) {
		// TODO 自动生成的构造函数存根
		this.truckID = truckID;
		this.truckNumber = truckNumber;
		this.years = years;
	}
	
	/**
	 * vo转po
	 */
	public TruckPO transToPO(){
		return new TruckPO(truckID,truckNumber,years);
	}


}
