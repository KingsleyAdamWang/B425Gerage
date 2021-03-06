package vo.IntermediateVo;

import java.util.Date;
import java.util.List;

import po.intermidatePO.TransferPO;
import vo.ReceiptsVO;
import enumSet.ReceiptsState;
import enumSet.TransportType;

public class TransferVO extends ReceiptsVO {
	// 时间
	public Date d;
	// 机构编号
	public String institutionID;
	// 中转中心的货运编号/航空编号
	public String transferID;
	// 出发地城市
	public String departure;
	// 目的地城市
	public String destination;

	// 该中转单所具有的所有物流的快递单号
	public List<String> list;
	// 中转产生的运费
	public double fare;
	// 中转的类型 飞机 火车 还是汽车
	public TransportType type;
	// 检装员
	public String name;
	// 根据类型不同 飞机是货柜号 火车是车厢号 汽车是押运员
	public String temp;

	public TransferVO(ReceiptsState state, String userID, Date d,
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

	public TransferVO(TransferPO po) {
		this(po.getState(), po.getUserID(), po.getD(), po.getInstitutionID(),
				po.getTransferID(), po.getDeparture(), po.getDestination(), po
						.getList(), po.getFare(), po.getType(), po.getName(),
				po.getTemp());
	}

	public TransferPO transToPO() {
		return new TransferPO(state, userID, d, institutionID, transferID,
				departure, destination, list, fare, type, name, temp);

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
		TransferVO other = (TransferVO) obj;
		if (transferID == null) {
			if (other.transferID != null)
				return false;
		} else if (!transferID.equals(other.transferID))
			return false;
		return true;
	}

}
