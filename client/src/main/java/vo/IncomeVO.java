package vo;

import java.util.Date;
import java.util.List;

import po.IncomePO;
import enumSet.ReceiptsState;

public class IncomeVO extends ReceiptsVO{

	private Date date;
	private double income;
	private String kdyID;
	private List<String> idList;

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



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getKdyID() {
		return kdyID;
	}

	public void setKdyID(String kdyID) {
		this.kdyID = kdyID;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

}
