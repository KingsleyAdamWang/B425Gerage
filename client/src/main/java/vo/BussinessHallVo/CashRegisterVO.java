package vo.BussinessHallVo;

import java.util.Date;
import java.util.List;

import vo.AdminVo.UserVO;

public class CashRegisterVO {
	public Date d;
	public double fare;
	public UserVO user;
	public List<String> idList;

	public CashRegisterVO(Date d, double fare, UserVO user, List<String> idList) {
		super();
		this.d = d;
		this.fare = fare;
		this.user = user;
		this.idList = idList;
	}

//	public CashRegisterVO() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Date getD() {
//		return d;
//	}
//
//	public void setD(Date d) {
//		this.d = d;
//	}
//
//	public double getFare() {
//		return fare;
//	}
//
//	public void setFare(double fare) {
//		this.fare = fare;
//	}
//
//	public UserVO getUser() {
//		return user;
//	}
//
//	public void setUser(UserVO user) {
//		this.user = user;
//	}
//
//	public List<String> getIdList() {
//		return idList;
//	}
//
//	public void setIdList(List<String> idList) {
//		this.idList = idList;
//	}
}
