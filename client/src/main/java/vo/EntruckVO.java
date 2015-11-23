package vo;

import java.util.Date;
import java.util.List;

import po.EntruckPO;
import enumSet.ReceiptsState;

public class EntruckVO extends ReceiptsVO {

	/**
	 * 装车时间
	 */
	private Date d;

	/**
	 * 汽运编号
	 */
	private String qyID;

	/**
	 * 到达地
	 */
	private String destination;

	/**
	 * 车辆代号
	 */
	private String truckID;

	/**
	 * 检装员
	 */
	private String checkName;

	/**
	 * 押运员
	 */
	private String deliverMan;

	/**
	 * 本次装车的所有ID 所有货物的订单条形码号
	 */

	List<String> IDlist;

	/**
	 * 本次运费
	 */
	double fare;

	/**
	 * 构造函数
	 * 
	 * @param state
	 * @param user
	 * @param d
	 * @param qyID
	 * @param destination
	 * @param truckID
	 * @param checkName
	 * @param deliverMan
	 * @param iDlist
	 * @param fare
	 */
	public EntruckVO(ReceiptsState state, String userID, Date d, String qyID,
			String destination, String truckID, String checkName,
			String deliverMan, List<String> iDlist, double fare) {
		super(state, userID);
		this.d = d;
		this.qyID = qyID;
		this.destination = destination;
		this.truckID = truckID;
		this.checkName = checkName;
		this.deliverMan = deliverMan;
		this.IDlist = iDlist;
		this.fare = fare;
	}

	public EntruckVO(EntruckPO po) {
		super(po.getState(), po.getUserID());
	}

	public EntruckPO transToPO() {
		return new EntruckPO(state, userID, d, qyID, destination, truckID,
				checkName, deliverMan, IDlist, fare);
	}

	public Date getD() {
		return d;
	}

	public String getQyID() {
		return qyID;
	}

	public String getDestination() {
		return destination;
	}

	public String getTruckID() {
		return truckID;
	}

	public String getCheckName() {
		return checkName;
	}

	public String getDeliverMan() {
		return deliverMan;
	}

	public List<String> getIDlist() {
		return IDlist;
	}

	public double getFare() {
		return fare;
	}

}
