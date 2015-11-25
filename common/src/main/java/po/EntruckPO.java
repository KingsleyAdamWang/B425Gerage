package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DateUtil;
import enumSet.ReceiptsState;

/**
 * 装车单po
 * 
 * @author 王栋
 *
 */
public class EntruckPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

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
	public EntruckPO(ReceiptsState state, String userID, Date d, String qyID,
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

	public EntruckPO(String data) {
		IDlist = new ArrayList<String>();
		String[] temp = data.split(" ");
		state = ReceiptsState.getReceiptsState(temp[0]);
		userID = temp[1];
		d = DateUtil.stringToDate(temp[2]);
		destination = temp[3];
		truckID = temp[4];
		checkName=temp[5];
		deliverMan = temp[6];
		fare = Double.parseDouble(temp[8]);
		String[] temp2 = temp[7].split(";");
		for(String str : temp2)
			IDlist.add(str);
		
	}

	public String toString() {
		StringBuilder result =  new StringBuilder(state.getReceiptsStateString() + " " + userID + " "
				+ DateUtil.dateToString(d) + " " + qyID + " " + destination
				+ " " + truckID + " " + checkName + " " + deliverMan + " ");
		for(String temp:IDlist)
			result.append(temp+";");
		result.append(" ");
		result.append(fare);
		result.append("\n");
		return result.toString();

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qyID == null) ? 0 : qyID.hashCode());
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
		EntruckPO other = (EntruckPO) obj;
		if (qyID == null) {
			if (other.qyID != null)
				return false;
		} else if (!qyID.equals(other.qyID))
			return false;
		return true;
	}
	
	


}
