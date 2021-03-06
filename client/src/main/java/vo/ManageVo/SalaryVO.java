package vo.ManageVo;

import java.util.List;

import po.managePO.SalaryPO;
import util.Salary;

public class SalaryVO {

	public List<Salary> salaryList;

	public SalaryVO(List<Salary> salaryList) {
		this.salaryList = salaryList;
	}

	public SalaryVO(SalaryPO po) {
		this(po.getSalaryList());
	}

	public SalaryPO transToPO() {
		return new SalaryPO(salaryList);
	}
}
