package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import enumSet.Position;
import util.Salary;

public class SalaryPO implements Serializable {

	private static final long serialVersionUID = 1L;

//	private Map<Position, Double> salaryMap;
	
	private List<Salary> salaryList;

	public SalaryPO(List<Salary> salaryList) {
	this.salaryList = salaryList;
	}

	public SalaryPO(String data) {
		salaryList = new ArrayList<Salary>();
		
		String[] temp = data.split(" ");
		for (String str : temp) {
		salaryList.add(new Salary(Position.getPosition(str.split(";")[0]), Double.parseDouble(str.split(";")[1])));
		}
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(Salary temp : salaryList){
			result.append(temp.getPosition().getPositionString()+";"+temp.getSalary()+" ");
		}
		result.append('\n');
		return result.toString();
	}

	public List<Salary> getSalaryList() {
		System.out.println(salaryList.size());
		return salaryList;
	}
	
	

}
