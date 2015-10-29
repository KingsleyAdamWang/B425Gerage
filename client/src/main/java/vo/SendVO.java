package vo;

public class SendVO {
	CustomerVO sender, receiver;
	GoodsVO goods;
	String type, id;
	double packageFare, totalFare;

	public SendVO(CustomerVO sender, CustomerVO receiver, GoodsVO goods,
			String type, String id, double packageFare, double totalFare) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.goods = goods;
		this.type = type;
		this.id = id;
		this.packageFare = packageFare;
		this.totalFare = totalFare;
	}

	public SendVO() {
		// TODO Auto-generated constructor stub
	}

	public CustomerVO getSender() {
		return sender;
	}

	public void setSender(CustomerVO sender) {
		this.sender = sender;
	}

	public CustomerVO getReceiver() {
		return receiver;
	}

	public void setReceiver(CustomerVO receiver) {
		this.receiver = receiver;
	}

	public GoodsVO getGoods() {
		return goods;
	}

	public void setGoods(GoodsVO goods) {
		this.goods = goods;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPackageFare() {
		return packageFare;
	}

	public void setPackageFare(double packageFare) {
		this.packageFare = packageFare;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
}
