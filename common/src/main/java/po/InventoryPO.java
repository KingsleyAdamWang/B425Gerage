package po;

import java.io.Serializable;

import util.Storage;

/**
 * 库存的PO
 * 
 * @author 王栋
 *
 */
public class InventoryPO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 中转中心机构编号
	 */
	private String institutionID;

	/**
	 * 要改用需求规格说明 假设一个中转中心内的四个分区的库存是一样的 即排架号的数量是一样的
	 */
	private Storage plane;// 航运区
	private Storage train;// 铁运区
	private Storage car;// 汽运区
	private Storage auto;// zi动区

	public InventoryPO(String institutionID, Storage plane, Storage train,
			Storage car, Storage auto) {
		super();
		this.institutionID = institutionID;
		this.plane = plane;
		this.train = train;
		this.car = car;
		this.auto = auto;
	}

	public InventoryPO(String data) {
		String temp[] = data.split(" ");
		this.institutionID = temp[0];
		this.plane = new Storage(Integer.parseInt(temp[1]),
				Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
		this.train = new Storage(Integer.parseInt(temp[4]),
				Integer.parseInt(temp[5]), Integer.parseInt(temp[6]));
		this.car = new Storage(Integer.parseInt(temp[7]),
				Integer.parseInt(temp[8]), Integer.parseInt(temp[9]));
		this.auto = new Storage(Integer.parseInt(temp[10]),
				Integer.parseInt(temp[11]), Integer.parseInt(temp[12]));
	}

	public String toString() {

		return institutionID + " " + plane.getRow() + " " + plane.getShelf()
				+ " " + plane.getPlace() + " " + train.getRow() + " "
				+ train.getShelf() + " " + train.getPlace() + " "
				+ car.getRow() + " " + car.getShelf() + " " + car.getPlace()
				+ " " + auto.getRow() + " " + auto.getShelf() + " "
				+ auto.getPlace() + "\n";
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
		InventoryPO other = (InventoryPO) obj;
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

	public void setPlane(Storage plane) {
		this.plane = plane;
	}

	public Storage getTrain() {
		return train;
	}

	public void setTrain(Storage train) {
		this.train = train;
	}

	public Storage getCar() {
		return car;
	}

	public void setCar(Storage car) {
		this.car = car;
	}

	public Storage getAuto() {
		return auto;
	}

	public void setAuto(Storage auto) {
		this.auto = auto;
	}

	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}

}
