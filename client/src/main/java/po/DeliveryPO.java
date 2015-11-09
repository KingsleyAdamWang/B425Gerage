package po;

import java.util.Date;

/**
 * 派件单PO==到达单PO
 * @author 王栋
 *
 */
public class DeliveryPO {
	/**
	 *时间对象
	 */
	private Date d;
	/**
	 * 派件单所派送的货物的快递单号
	 */
	private String id;
	/**
	 * 派送员姓名
	 */
	private String name;
	
	
	public DeliveryPO(Date d, String id, String name) {
		super();
		this.d = d;
		this.id = id;
		this.name = name;
	}
	
	
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
}
