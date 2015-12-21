package vo.ManageVo;

import java.util.List;

import po.PriceConstPO;
import util.Distance;
import util.PackPrice;

public class PriceConstVO {
	// 同城 各个营业厅之间的距离
	public static final double LOCAL_DISTANCE = 30.0;

	// 一次货运量的最大值 飞机火车汽车
	public static final int PLANE_MAX = 5000;
	public static final int TRAIN_MAX = 200000;
	public static final int CAR_MAX = 1000;

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

	public PriceConstVO(double planeCost, double trainCost, double carCost,
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

	public PriceConstVO(PriceConstPO po) {
		
	
		this.planeCost = po.getPlaneCost();
		this.trainCost = po.getTrainCost();
		this.carCost = po.getCarCost();
		this.economy = po.getEconomy();
		this.standard = po.getStandard();
		this.fast = po.getFast();
		this.standard_const = po.getStandard_const();
		this.distances = po.getDistances();
		this.packPrice = po.getPackPrice();
		
	}
	
	
	public PriceConstPO transToPO() {
		return new PriceConstPO(planeCost, trainCost, carCost, economy,
				standard, fast, standard_const, distances, packPrice);
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

	public static double getLocalDistance() {
		return LOCAL_DISTANCE;
	}

	public static int getPlaneMax() {
		return PLANE_MAX;
	}

	public static int getTrainMax() {
		return TRAIN_MAX;
	}

	public static int getCarMax() {
		return CAR_MAX;
	}

}
