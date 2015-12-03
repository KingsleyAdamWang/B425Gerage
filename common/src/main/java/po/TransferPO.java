package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DateUtil;
import enumSet.ReceiptsState;
import enumSet.TransportType;

public class TransferPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 时间
	private Date d;
	// 机构编号
	private String institutionID;
	// 中转中心的货运编号/航空编号
	private String transferID;
	// 出发地城市
	private String departure;
	// 目的地城市
	private String destination;

	// 该中转单所具有的所有物流的快递单号
	private List<String> list;
	// 中转产生的运费
	private double fare;
	// 中转的类型 飞机 火车 还是汽车
	private TransportType type;
	// 检装员
	private String name;
	// 根据类型不同 飞机是货柜号 火车是车厢号 汽车是押运员
	private String temp;

	/**
	 * 中转单的构造函数
	 * 
	 * @param state
	 * @param user
	 * @param d
	 * @param institutionID
	 * @param transferID
	 * @param departure
	 * @param destination
	 * @param list
	 * @param fare
	 * @param type
	 * @param name
	 * @param temp
	 */
	public TransferPO(ReceiptsState state, String userID, Date d,
			String institutionID, String transferID, String departure,
			String destination, List<String> list, double fare,
			TransportType type, String name, String temp) {
		super(state, userID);
		this.d = d;
		this.institutionID = institutionID;
		this.transferID = transferID;
		this.departure = departure;
		this.destination = destination;
		this.list = list;
		this.fare = fare;
		this.type = type;
		this.name = name;
		this.temp = temp;
	}

	public TransferPO(String data) {
		String tem[] = data.split(" ");
		state = ReceiptsState.getReceiptsState(tem[0]);
		userID = tem[1];
		d = DateUtil.stringToDate(tem[2]);
		institutionID = tem[3];
		transferID = tem[4];
		departure = tem[5];
		destination = tem[6];
		fare = Double.parseDouble(tem[8]);
		type = TransportType.getTransportType(tem[9]);
		name = tem[10];
		temp = tem[11];
		String tem1[] = tem[7].split(" ");
		list = new ArrayList<String>();
		for (String str : tem1) {
			list.add(str);
		}
	}

	public String toString() {
		String temp = state.getReceiptsStateString() + " " + userID + " "
				+ DateUtil.dateToString(d) + " " + institutionID + " "
				+ transferID + " " + departure + " " + destination + " ";
		StringBuilder result = new StringBuilder(temp);

		for (String str : list) {
			result.append(str + ";");
		}

		result.append(" " + fare + " " + type.getTransportTypeString() + " "
				+ name + " " + temp + "\n");
		return result.toString();

	}

	public Date getD() {
		return d;
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public String getTransferID() {
		return transferID;
	}

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}

	public List<String> getList() {
		return list;
	}

	public double getFare() {
		return fare;
	}

	public TransportType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getTemp() {
		return temp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((transferID == null) ? 0 : transferID.hashCode());
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
		TransferPO other = (TransferPO) obj;
		if (transferID == null) {
			if (other.transferID != null)
				return false;
		} else if (!transferID.equals(other.transferID))
			return false;
		return true;
	}
	
	

}
