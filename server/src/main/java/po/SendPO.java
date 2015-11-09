package po;

import java.util.Date;

import enumSet.Express;
import enumSet.PackType;
import enumSet.ReceiptsState;


public class SendPO extends ReceiptsPO{
	
	//寄件时间
	private Date d;
	//寄件人的基本信息
	private CustomerPO sender;
	//收件人的基本信息
	private CustomerPO receiver;
	//寄件的个数
	private int goodsNum;
	//快递物品的名称
	private String name;
	//快递的重量
	private double weight;
	//快递的体积
	private double volume;
	//快递的种类
	private Express expressType;
	//快递的包装的种类
	private PackType packType;
	//预计到达时间 在没有历史数据的情况下是显示0
	
	private Date arriveDate;
	
	
	
	

	/**
	 * 寄件单的PO构造函数
	 * @param state
	 * @param user
	 * @param d
	 * @param sender
	 * @param receiver
	 * @param goodsNum
	 * @param name
	 * @param weight
	 * @param volume
	 * @param expressType
	 * @param packType
	 * @param arriveDate
	 */

	public SendPO(ReceiptsState state, UserPO user, Date d, CustomerPO sender,
			CustomerPO receiver, int goodsNum, String name, double weight,
			double volume, Express expressType, PackType packType,
			Date arriveDate) {
		super(state, user);
		this.d = d;
		this.sender = sender;
		this.receiver = receiver;
		this.goodsNum = goodsNum;
		this.name = name;
		this.weight = weight;
		this.volume = volume;
		this.expressType = expressType;
		this.packType = packType;
		this.arriveDate = arriveDate;
	}




	public Date getD() {
		return d;
	}




	public void setD(Date d) {
		this.d = d;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Date getArriveDate() {
		return arriveDate;
	}




	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}




	public CustomerPO getSender() {
		return sender;
	}


	public void setSender(CustomerPO sender) {
		this.sender = sender;
	}


	public CustomerPO getReceiver() {
		return receiver;
	}


	public void setReceiver(CustomerPO receiver) {
		this.receiver = receiver;
	}


	public int getGoodsNum() {
		return goodsNum;
	}


	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getVolume() {
		return volume;
	}


	public void setVolume(double volume) {
		this.volume = volume;
	}


	public Express getExpressType() {
		return expressType;
	}


	public void setExpressType(Express expressType) {
		this.expressType = expressType;
	}


	public PackType getPackType() {
		return packType;
	}


	public void setPackType(PackType packType) {
		this.packType = packType;
	}
	
	
	
	
	
}
