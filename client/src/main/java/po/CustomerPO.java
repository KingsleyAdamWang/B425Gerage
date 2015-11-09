package po;

public class CustomerPO {

	// 顾客的姓名
	private String name;
	//顾客的寄件或者收件的城市  南京？北京?上海?天津？
	private String city;
	// 顾客的地址
	private String address;

	// 顾客的单位
	private String company;
	// 顾客的电话号码
	private String telephone;

	
	
	public CustomerPO(String name, String city, String address, String company,
			String telephone) {
		super();
		this.name = name;
		this.city = city;
		this.address = address;
		this.company = company;
		this.telephone = telephone;
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
