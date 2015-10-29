package vo;

import java.util.Date;

public class LogisticsVO {
	private Date date;
	private String address;
	private String name;
	private String number;

	public LogisticsVO(Date d, String a) {
		date = d;
		address = a;
	}

	public LogisticsVO(Date d, String a, String n, String num) {
		date = d;
		address = a;
		name = n;
		number = num;
	}

	public Date getDate() {
		return date;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public void setDate(Date d) {
		date = d;
	}

	public void setAddress(String s) {
		address = s;
	}

	public void setName(String s) {
		name = s;
	}

	public void setNumber(String s) {
		number = s;
	}
}
