package vo;

public class GoodsVO {
	int amount;
	double weight, volume;
	String name;

	public GoodsVO(int amount, double weight, double volume, String name) {
		super();
		this.amount = amount;
		this.weight = weight;
		this.volume = volume;
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
