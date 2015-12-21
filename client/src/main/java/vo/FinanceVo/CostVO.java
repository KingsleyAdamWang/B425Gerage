package vo.FinanceVo;

import java.util.List;

import vo.BussinessHallVo.CashRegisterVO;

public class CostVO {
	List<CashRegisterVO> cash;
	List<PaymentVO> pay;
	double cost;

	public CostVO(List<CashRegisterVO> cash, List<PaymentVO> pay) {
		super();
		this.cash = cash;
		this.pay = pay;

	}

	public List<CashRegisterVO> getCash() {
		return cash;
	}

	public void setCash(List<CashRegisterVO> cash) {
		this.cash = cash;
	}

	public List<PaymentVO> getPay() {
		return pay;
	}

	public void setPay(List<PaymentVO> pay) {
		this.pay = pay;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
