package vo.BussinessHallVo;

import java.util.Date;
import java.util.List;

import po.businessPO.EntruckPO;
import util.DateUtil;
import vo.ReceiptsVO;
import enumSet.ReceiptsState;

public class EntruckVO extends ReceiptsVO {

	/**
	 * 装车时间
	 */
	 public String d;

	/**
	 * 汽运编号
	 */
	public  String qyID;

	/**
	 * 到达地
	 */
	public  String destination;

	/**
	 * 车辆代号
	 */
	public  String truckID;

	/**
	 * 检装员
	 */
	public  String checkName;

	/**
	 * 押运员
	 */
	public  String deliverMan;

	/**
	 * 本次装车的所有ID 所有货物的订单条形码号
	 */

	public List<String> IDlist;

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
	public EntruckVO(ReceiptsState state, String userID, String d, String qyID,
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
		return new EntruckPO(state, userID, DateUtil.stringToDate(d), qyID, destination, truckID,
				checkName, deliverMan, IDlist, fare);
	}


}
