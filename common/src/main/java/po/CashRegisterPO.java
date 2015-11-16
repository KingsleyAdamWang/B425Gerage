package po;

import java.util.Date;
import java.util.List;

/**
 * 收款单
 * 
 * @author 王栋
 *
 */
public class CashRegisterPO {

	// 收款单时间
	private Date d;

	// 快递员姓名
	private String deliverMan;

	// 对应的所有的快递条形码号
	private List<String> IDList;

	/**
	 * 构造函数
	 * 
	 * @param d
	 * @param deliverMan
	 * @param iDList
	 */
	public CashRegisterPO(Date d, String deliverMan, List<String> iDList) {
		super();
		this.d = d;
		this.deliverMan = deliverMan;
		IDList = iDList;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getDeliverMan() {
		return deliverMan;
	}

	public void setDeliverMan(String deliverMan) {
		this.deliverMan = deliverMan;
	}

	public List<String> getIDList() {
		return IDList;
	}

	public void setIDList(List<String> iDList) {
		IDList = iDList;
	}

}
