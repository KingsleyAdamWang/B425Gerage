package vo;

import java.util.Date;
import java.util.List;

import po.IncomePO;
import enumSet.ReceiptsState;

public class IncomeVO extends ReceiptsVO{
	 Date date;
	 double income;
	 String kdyID;
	 List<String> idList;

	/**
	 * 构造函数
	 * 
	 * @param state
	 * @param userID
	 * @param date
	 * @param income
	 * @param kdyID
	 * @param idList
	 */
	public IncomeVO(ReceiptsState state, String userID, Date date,
			double income, String kdyID, List<String> idList) {
		super(state, userID);
		this.date = date;
		this.income = income;
		this.kdyID = kdyID;
		this.idList = idList;
	}
	
	/**
	 * po转为vo对象
	 * @param po
	 */
	public IncomeVO(IncomePO po){
		super(po.getState(), po.getUserID());

		this.date=po.getDate();
		this.income = po.getIncome();
		this.kdyID = po.getKdyID();
		this.idList = po.getIdList();
	}

	/**
	 * 由vo转为po
	 * @return
	 */
	public IncomePO transToPO(){
		return new IncomePO(state, kdyID, date, income, kdyID, idList);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((kdyID == null) ? 0 : kdyID.hashCode());
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
		IncomeVO other = (IncomeVO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (kdyID == null) {
			if (other.kdyID != null)
				return false;
		} else if (!kdyID.equals(other.kdyID))
			return false;
		return true;
	}
}
