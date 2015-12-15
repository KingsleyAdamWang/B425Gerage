package util;

import java.io.Serializable;

import enumSet.Position;

public class Salary implements Serializable{

	
	private static final long serialVersionUID = 1L;
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
