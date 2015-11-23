package vo;

import po.TruckPO;

public class TruckVO {
	// 车的编号
	private String truckID;
	// 车牌号
	private String truckNumber;
	// 服役时间
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

	public TruckVO(TruckPO po) {
		this(po.getTruckID(),po.getTruckNumber(),po.getYears());
	}

	public TruckVO(String truckID, String truckNumber, int years) {
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
