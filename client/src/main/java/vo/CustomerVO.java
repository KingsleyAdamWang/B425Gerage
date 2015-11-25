package vo;

import po.CustomerPO;

public class CustomerVO {
	// 顾客的姓名
	public String name;

	// 顾客的寄件或者收件的城市 南京？北京?上海?天津？
	public  String city;

	// 顾客的邮编
	public  String postCode;

	// 顾客的地址
	public  String address;

	// 顾客的单位
	public  String company;

	// 顾客的电话号码
	public  String telephone;

	
	
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
	

}
