package util;

import enumSet.PackType;

public class PackPrice {

	private PackType type;
	private double fare;

	public PackPrice(PackType type, double fare) {
		super();
		this.type = type;
		this.fare = fare;
	}

	public PackPrice(String data) {
		String temp[] = data.split(";");
		this.type = PackType.getPackType(temp[0]);
		this.fare = Double.parseDouble(temp[1]);
	}

	public PackType getType() {
		return type;
	}

	public void setType(PackType type) {
		this.type = type;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
