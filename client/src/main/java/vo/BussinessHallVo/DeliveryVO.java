package vo.BussinessHallVo;

import java.util.Date;

import po.DeliveryPO;
import vo.ReceiptsVO;
import enumSet.ReceiptsState;

public class DeliveryVO extends ReceiptsVO {
	public Date d;
	public String id;
	public String name;

	public DeliveryVO(ReceiptsState state, String userID, Date d, String id,
			String name) {
		super(state, userID);
		this.d = d;
		this.id = id;
		this.name = name;
	}

	public DeliveryVO(DeliveryPO po) {
		this(po.getState(), po.getUserID(), po.getD(), po.getId(), po.getName());
	}

	public DeliveryPO transToPO() {
		return new DeliveryPO(state, userID, d, id, name);
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
		DeliveryVO other = (DeliveryVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
