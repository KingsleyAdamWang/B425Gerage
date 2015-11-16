package po;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

import util.DateUtil;
import enumSet.Express;
import enumSet.PackType;
import enumSet.ReceiptsState;

public class SendPO extends ReceiptsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 寄件时间
	private Date d;
	// 寄件人的基本信息
	private CustomerPO sender;
	// 收件人的基本信息
	private CustomerPO receiver;
	// 寄件的个数
	private int goodsNum;
	// 快递物品的名称
	private String name;
	// 快递的重量
	private double weight;
	// 快递的体积
	private double volume;
	// 快递的种类
	private Express expressType;
	// 快递的包装的种类
	private PackType packType;
	// 快递费用 自动生成
	private double fare;
	// 预计到达时间 在没有历史数据的情况下是显示0
	private int arriveDate;

	/**
	 * 寄件单的PO构造函数
	 * 
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

	// The constructor SendPO(ReceiptsState, UserPO, Date, CustomerPO,
	// CustomerPO, int, String, double, double, Express, Package, Date) is
	// undefined
	
	//构造方法
	public SendPO(Date d, CustomerPO sender, CustomerPO receiver, int goodsNum,
			String name, double weight, double volume, Express expressType,
			PackType packType, double fare, int arriveDate) {
		super();
		this.d = d;
		this.sender = sender;
		this.receiver = receiver;
		this.goodsNum = goodsNum;
		this.name = name;
		this.weight = weight;
		this.volume = volume;
		this.expressType = expressType;
		this.packType = packType;
		this.fare = fare;
		this.arriveDate = arriveDate;
	}



   //从读取的数据中构造一个对应的po对象
	public SendPO(String data){
//		super(state, user);
		String strs[] = data.split(" ");
		this.userID = strs[0];
	    this.sender = new CustomerPO(strs[1]);
	    this.receiver = new CustomerPO(strs[2]);
	    String strsO[] = strs[3].split(" ");
	    this.state = ReceiptsState.getReceiptsState(strsO[0]);
	    this.d =  DateUtil.stringToDate(strsO[1]);
	    this.goodsNum=Integer.parseInt(strsO[2]);
	    this.name = strsO[3];
	    this.weight=Double
				.parseDouble(strsO[4]);
	    this.volume=Double
				.parseDouble(strsO[5]);
	    this.arriveDate = Integer
				.parseInt(strsO[9]);
	    this.expressType =  Express
				.getExpress(strsO[6]);
	    this.packType=PackType
				.getPackType(strsO[7]);
	    this.fare = Double
				.parseDouble(strsO[8]);
	}
	
	

	public String toString() {
		return this.userID+ ";" + sender.toString() + ";"
				+ receiver.toString() + ";" + state.getReceiptsStateString()
				+ " " + DateUtil.dateToString(d) + " "
				+ String.valueOf(goodsNum) + " " + name + " "
				+ String.valueOf(weight) + " " + String.valueOf(volume) + " "
				+ expressType.getExpressString() + " "
				+ packType.getPackTypeString() + " " + String.valueOf(fare)
				+ " " + String.valueOf(arriveDate);
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public void setArriveDate(int arriveDate) {
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
