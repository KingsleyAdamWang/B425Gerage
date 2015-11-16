package vo;

import po.CustomerPO;

public class CustomerVO {
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
	
	
	public CustomerVO(CustomerPO po){
		this(po.getName(),po.getCity(),po.getPostCode(),po.getAddress(),po.getCompany(),po.getTelephone());
	}
	
	
	public CustomerVO(String name, String city, String postCode,
			String address, String company, String telephone) {
		super();
		this.name = name;
		this.city = city;
		this.postCode = postCode;
		this.address = address;
		this.company = company;
		this.telephone = telephone;
	}



   public  CustomerPO transToPO(){
	   return new CustomerPO(name,city,postCode,address,company,telephone);
   }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
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
		CustomerVO other = (CustomerVO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
}
