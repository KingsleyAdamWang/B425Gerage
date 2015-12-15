package vo;

import java.util.Date;

import po.SendPO;
import enumSet.Express;
import enumSet.PackType;
import enumSet.ReceiptsState;

public class SendVO extends ReceiptsVO {

	public  String id;
	// 寄件时间
	public Date d;
	// 寄件人的基本信息
	public  CustomerVO sender;
	// 收件人的基本信息
	public  CustomerVO receiver;
	// 寄件的个数
	public  int goodsNum;
	// 快递物品的名称
	public  String name;
	// 快递的重量
	public  double weight;
	// 快递的体积
	public  double volume;
	// 快递的种类
	public  Express expressType;
	// 快递的包装的种类
	public  PackType packType;
	// 快递费用 自动生成
	public  double fare;
	// 预计到达时间 在没有历史数据的情况下是显示0
	public  int arriveDate;

	public SendVO(SendPO po) {
		this(po.getState(), po.getUserID(), po.getId(), po.getD(),
				new CustomerVO(po.getSender()),
				new CustomerVO(po.getReceiver()), po.getGoodsNum(), po
						.getName(), po.getWeight(), po.getVolume(), po
						.getExpressType(), po.getPackType(), po.getFare(), po
						.getArriveDate());
	}

	public SendVO(ReceiptsState state, String userID, String id, Date d,
			CustomerVO sender, CustomerVO receiver, int goodsNum, String name,
			double weight, double volume, Express expressType,
			PackType packType, double fare, int arriveDate) {
		super(state, userID);
		this.d = d;
		this.id = id;
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

	/**
	 * vo转为po
	 * 
	 * @return
	 */
	public SendPO transToPO() {
		return new SendPO(state, name, id, d, sender.transToPO(),
				receiver.transToPO(), goodsNum, name, weight, volume,
				expressType, packType, fare, arriveDate);
	}

	public Date getD() {
		return d;
	}

	public CustomerVO getSender() {
		return sender;
	}

	public CustomerVO getReceiver() {
		return receiver;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolume() {
		return volume;
	}

	public Express getExpressType() {
		return expressType;
	}

	public PackType getPackType() {
		return packType;
	}

	public double getFare() {
		return fare;
	}

	public int getArriveDate() {
		return arriveDate;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SendVO other = (SendVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
