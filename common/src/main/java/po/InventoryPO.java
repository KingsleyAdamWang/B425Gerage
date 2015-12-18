package po;

import java.io.Serializable;

import enumSet.InventoryArea;
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
	private boolean[] isBusy1;
	private boolean[] isBusy2;
	private boolean[] isBusy3;
	private boolean[] isBusy4;

	public InventoryPO(String institutionID, Storage plane, Storage train,
			Storage car, Storage auto) {
		super();
		this.institutionID = institutionID;
		this.plane = plane;
		this.train = train;
		this.car = car;
		this.auto = auto;
		isBusy1 = new boolean[plane.getNum()];
		isBusy2 = new boolean[train.getNum()];
		isBusy3 = new boolean[car.getNum()];
		isBusy4 = new boolean[auto.getNum()];
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

		this.isBusy1 = getBusy(temp[13]);
		this.isBusy2 = getBusy(temp[14]);
		this.isBusy3 = getBusy(temp[15]);
		this.isBusy4 = getBusy(temp[16]);
	}

	private boolean[] getBusy(String data) {
		boolean[] result = new boolean[data.length()];
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == '0')
				result[i] = false;
			else
				result[i] = true;
		}
		return result;
	}

	private String getBusyString(boolean[] data) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			if (data[i])
				str.append("1");
			else
				str.append("0");
		}
		return str.toString();
	}

	
	public boolean isBusy(InventoryArea area, int num) {
		boolean temp[];

		switch (area) {
		case AREA_FOR_PLANE:
			temp = isBusy1;
			break;
		case AREA_FOR_TRAIN:
			temp = isBusy2;
			break;
		case AREA_FOR_CAR:
			temp = isBusy3;
			break;
		default:
			temp = isBusy4;
		}

		return temp[num - 1];
	}
	
	public boolean alert(InventoryArea area, double rate){
		boolean temp[];
		switch (area) {
		case AREA_FOR_PLANE:
			temp= isBusy1;
			break;
		case AREA_FOR_TRAIN:
			temp=isBusy2;
			break;
		case AREA_FOR_CAR:
			temp=isBusy3;
			break;
		default:
			temp=isBusy4;
		}
		long total=temp.length;
		long result=(long) (total*rate);
		long count=0;
		for(boolean bool:temp){
			if(bool){
				count++;
			}
		}
		
		if(count>result){
			return true;
		}else{
			return false;
		}
	}
	
	public void setIsBusy(InventoryArea area, int num,boolean  isBusy){
		
		switch (area) {
		case AREA_FOR_PLANE:
			 isBusy1[num-1]=isBusy;
			break;
		case AREA_FOR_TRAIN:
			isBusy2[num-1]=isBusy;
			break;
		case AREA_FOR_CAR:
			isBusy3[num-1]=isBusy;
			break;
		default:
			isBusy4[num-1]=isBusy;
		}
	}

	public String toString() {

		return institutionID + " " + plane.getRow() + " " + plane.getShelf()
				+ " " + plane.getPlace() + " " + train.getRow() + " "
				+ train.getShelf() + " " + train.getPlace() + " "
				+ car.getRow() + " " + car.getShelf() + " " + car.getPlace()
				+ " " + auto.getRow() + " " + auto.getShelf() + " "
				+ auto.getPlace() + " " + getBusyString(isBusy1) + " "
				+ getBusyString(isBusy2) + " " + getBusyString(isBusy3) + " "
				+ getBusyString(isBusy4) + "\n";
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
