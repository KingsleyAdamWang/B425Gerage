package vo.DeliverymanVo;

import java.util.Date;

import po.deliveryPO.ReceivePO;
import util.DateUtil;
import vo.ReceiptsVO;
import enumSet.ReceiptsState;

public class ReceiveVO extends ReceiptsVO {
	public String id, name, telNum, d;

	public ReceiveVO(ReceiptsState state, String userID, String id,
			String name, String telNum, String d) {
		super(state, userID);
		this.id = id;
		this.name = name;
		this.telNum = telNum;
		this.d = d;
	}

	public ReceiveVO(ReceivePO po) {
		this(po.getState(), po.getUserID(), po.getId(), po.getName(), po
				.getTelNum(), DateUtil.dateToString(po.getD()));

	}

	public ReceivePO transToPO() {
		return new ReceivePO(state, userID, id, name, telNum,
				DateUtil.stringToDate(d));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ReceiveVO other = (ReceiveVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
