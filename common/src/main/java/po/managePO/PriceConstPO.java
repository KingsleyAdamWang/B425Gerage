package po.managePO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Distance;
import util.PackPrice;

/*
 * 价格距离常量
 */
public class PriceConstPO implements Serializable {

	private static  final long serialVersionUID = 1L;



	// 价格常量 分别代表三种交通运输工具的 价格常量 每公里每吨的价格常量
	private double planeCost;
	private double trainCost;
	private double carCost;

	// 三种方式快递的价格比
	private double economy;
	private double standard;
	private double fast;

	// 标准快递的运费价格常量 公里数/1000*23 该处这个23即为价格常量 需要总经理进行常量制定
	// 制定好后便储存这些数据 等填写表单的时候自动获取这些数据
	private double standard_const;

	// // 距离
	// private HashMap<String, Double> distance;
	// // 包装费用
	// private HashMap<PackType, Double> packPrice;

	private List<Distance> distances;

	private List<PackPrice> packPrice;

	public PriceConstPO(double planeCost, double trainCost, double carCost,
			double economy, double standard, double fast,
			double standard_const, List<Distance> distances,
			List<PackPrice> packPrice) {
		super();
		this.planeCost = planeCost;
		this.trainCost = trainCost;
		this.carCost = carCost;
		this.economy = economy;
		this.standard = standard;
		this.fast = fast;
		this.standard_const = standard_const;
		this.distances = distances;
		this.packPrice = packPrice;
	}

	public PriceConstPO(List<String> data) {
		this.distances = new ArrayList<Distance>();
		this.packPrice = new ArrayList<PackPrice>();
		String temp1[] = data.get(0).split(" ");
		this.planeCost = Double.parseDouble(temp1[0]);
		this.trainCost = Double.parseDouble(temp1[1]);
		this.carCost = Double.parseDouble(temp1[2]);
		String temp2[] = data.get(1).split(" ");
		this.economy = Double.parseDouble(temp2[0]);
		this.standard = Double.parseDouble(temp2[1]);
		this.fast = Double.parseDouble(temp2[2]);
		this.standard_const = Double.parseDouble(data.get(2));
		for (String temp : data.get(3).split(" "))
			distances.add(new Distance(temp));
		for (String temp : data.get(4).split(" "))
			packPrice.add(new PackPrice(temp));
	}

	public String toString() {
		String result = planeCost + " " + trainCost + " " + carCost + "\n"
				+ economy + " " + standard + " " + fast + " " + "\n"
				+ standard_const + "\n";
		for (Distance dis : distances) {
			result += (dis.getCity1() + ";" + dis.getCity2() + ";"
					+ dis.getDistance() + " ");
		}

		result += "\n";
		for (PackPrice pp : packPrice) {
			result += (pp.getType().getPackTypeString() + ";" + pp.getFare() + " ");
		}
		result += "\n";

		return result;
	}

	public double getPlaneCost() {
		return planeCost;
	}

	public void setPlaneCost(double planeCost) {
		this.planeCost = planeCost;
	}

	public double getTrainCost() {
		return trainCost;
	}

	public void setTrainCost(double trainCost) {
		this.trainCost = trainCost;
	}

	public double getCarCost() {
		return carCost;
	}

	public void setCarCost(double carCost) {
		this.carCost = carCost;
	}

	public double getEconomy() {
		return economy;
	}

	public void setEconomy(double economy) {
		this.economy = economy;
	}

	public double getStandard() {
		return standard;
	}

	public void setStandard(double standard) {
		this.standard = standard;
	}

	public double getFast() {
		return fast;
	}

	public void setFast(double fast) {
		this.fast = fast;
	}

	public double getStandard_const() {
		return standard_const;
	}

	public void setStandard_const(double standard_const) {
		this.standard_const = standard_const;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<Distance> getDistances() {
		return distances;
	}

	public void setDistances(List<Distance> distances) {
		this.distances = distances;
	}

	public List<PackPrice> getPackPrice() {
		return packPrice;
	}

	public void setPackPrice(List<PackPrice> packPrice) {
		this.packPrice = packPrice;
	}

}
