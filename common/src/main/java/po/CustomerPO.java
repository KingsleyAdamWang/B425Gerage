package po;

import java.io.Serializable;

public class CustomerPO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 顾客的姓名
	private String name;

	// 顾客的寄件或者收件的城市 南京？北京?上海?天津？
	private String city;

	// 顾客的邮编
	private String postCode;

	// 顾客的地址
	private String address;

	// 顾客的单位
	private String company;

	// 顾客的电话号码
	private String telephone;

	/**
	 * 构造函数
	 * 
	 * @param name
	 * @param city
	 * @param postCode
	 * @param address
	 * @param company
	 * @param telephone
	 */
	public CustomerPO(String name, String city, String postCode,
			String address, String company, String telephone) {
		super();
		this.name = name;
		this.city = city;
		this.postCode = postCode;
		this.address = address;
		this.company = company;
		this.telephone = telephone;
	}

	// 读文件的时候可以这样用来构造一个 对应的 寄件人和收件人的对应的po
	// 寄件单操作需要用到
	public CustomerPO(String data) {
		String strs[] = data.split(";");
		this.name = strs[0];
		this.city = strs[1];
		this.postCode = strs[2];
		this.address = strs[3];
		this.company = strs[4];
		this.telephone = strs[5];
	}

	public String toString() {

		return getName() + ";" + getCity() + ";" + getPostCode() + ";"
				+ getAddress() + ";" + getCompany() + ";" + getTelephone();
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



}
