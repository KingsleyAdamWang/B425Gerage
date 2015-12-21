package vo.InventoryVo;

import po.inventoryPO.InventoryPO;
import util.Storage;

public class InventoryVO {

	/**
	 * 中转中心机构编号
	 */
	public  String institutionID;

	/**
	 * 要改用需求规格说明 假设一个中转中心内的四个分区的库存是一样的 即排架号的数量是一样的
	 */
	public  Storage plane;// 航运区
    public  Storage train;// 铁运区
	public  Storage car;// 汽运区
	public  Storage auto;// zi动区

	public InventoryVO(String institutionID, Storage plane, Storage train,
			Storage car, Storage auto) {
		super();
		this.institutionID = institutionID;
		this.plane = plane;
		this.train = train;
		this.car = car;
		this.auto = auto;
	}

	public InventoryVO(InventoryPO po) {
		this(po.getInstitutionID(), po.getPlane(), po.getTrain(), po.getCar(),
				po.getAuto());

	}

	public InventoryPO transToPO() {
		return new InventoryPO(institutionID, plane, train, car, auto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((institutionID == null) ? 0 : institutionID.hashCode());
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
		InventoryVO other = (InventoryVO) obj;
		if (institutionID == null) {
			if (other.institutionID != null)
				return false;
		} else if (!institutionID.equals(other.institutionID))
			return false;
		return true;
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public Storage getPlane() {
		return plane;
	}

	public Storage getTrain() {
		return train;
	}



	public Storage getCar() {
		return car;
	}

	public Storage getAuto() {
		return auto;
	}


}
