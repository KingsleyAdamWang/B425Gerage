package po;

import java.io.Serializable;

/**
 * 库存的PO
 * @author 王栋
 *
 */
public class InventoryPO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 中转中心机构编号
	 */
	private String institutionID;
	
	/**
	 * 要改用需求规格说明  假设一个中转中心内的四个分区的库存是一样的 即排架号的数量是一样的
	 */
	private int  row1, shelf1, place1;//航运区
	private int  row2, shelf2, place2;//铁运区
	private int  row3, shelf3, place3;//汽运区
	private int  row4, shelf4, place4;//机动区
	
	
	
	
	
	/**
	 * 构造方法
	 * @param institutionID
	 * @param row1
	 * @param shelf1
	 * @param place1
	 * @param row2
	 * @param shelf2
	 * @param place2
	 * @param row3
	 * @param shelf3
	 * @param place3
	 * @param row4
	 * @param shelf4
	 * @param place4
	 */
	public InventoryPO(String institutionID, int row1, int shelf1, int place1,
			int row2, int shelf2, int place2, int row3, int shelf3, int place3,
			int row4, int shelf4, int place4) {
		super();
		this.institutionID = institutionID;
		this.row1 = row1;
		this.shelf1 = shelf1;
		this.place1 = place1;
		this.row2 = row2;
		this.shelf2 = shelf2;
		this.place2 = place2;
		this.row3 = row3;
		this.shelf3 = shelf3;
		this.place3 = place3;
		this.row4 = row4;
		this.shelf4 = shelf4;
		this.place4 = place4;
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
	public int getRow1() {
		return row1;
	}
	public int getShelf1() {
		return shelf1;
	}
	public int getPlace1() {
		return place1;
	}
	public int getRow2() {
		return row2;
	}
	public int getShelf2() {
		return shelf2;
	}
	public int getPlace2() {
		return place2;
	}
	public int getRow3() {
		return row3;
	}
	public int getShelf3() {
		return shelf3;
	}
	public int getPlace3() {
		return place3;
	}
	public int getRow4() {
		return row4;
	}
	public int getShelf4() {
		return shelf4;
	}
	public int getPlace4() {
		return place4;
	}
	
	
	
	

}
