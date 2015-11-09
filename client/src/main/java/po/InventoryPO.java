package po;

/**
 * 库存的PO
 * @author 王栋
 *
 */
public class InventoryPO {
	/**
	 * 中转中心机构编号
	 */
	private String institutionID;
	
	/**
	 * 要改用需求规格说明  假设一个中转中心内的四个分区的库存是一样的 即排架号的数量是一样的
	 */
	private int  row, shelf, place;
	
	

}
