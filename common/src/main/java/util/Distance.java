package util;

import java.io.Serializable;

public class Distance implements Serializable{

	private String city1;
	private String city2;
	private double distance;
	
	
	public Distance(String city1, String city2, double distance) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
	}
	
	
	public Distance(String data){
		String temp[] = data.split(";");
		city1 =temp[0];
		city2 = temp[1];
		distance = Double.parseDouble(temp[2]);
		
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city1 == null) ? 0 : city1.hashCode());
		result = prime * result + ((city2 == null) ? 0 : city2.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Distance other = (Distance) obj;
		if(other.city1.equals(city1)&&other.city2.equals(city2))
				return true;
		if(other.city2.equals(city1)&&other.city1.equals(city2))
			return true;
		return true;
	}
	
	
	
}
