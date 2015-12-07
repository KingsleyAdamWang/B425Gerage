package util;

import enumSet.Position;

public class Salary {

	private Position position;
	private double salary;
	
	public Salary(Position position,double salary){
		this.position = position;
		this.salary = salary;
		
	}

	public Position getPosition() {
		return position;
	}

	public double getSalary() {
		return salary;
	}
	
	
}
