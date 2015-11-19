package po;

import java.io.Serializable;
import java.util.HashMap;

public class ManageStrategyPO implements Serializable{
	
	private static final long serialVersionUID = 1L;


	// 同城 各个营业厅之间的距离
	public static final double LOCAL_DISTANCE = 30.0;

	//一次货运量的最大值  飞机火车汽车
	private static final int PLANE_MAX = 5000;
	private static final int TRAIN_MAX = 200000;
	private static final int CAR_MAX = 1000;

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
	
	//距离
	private HashMap<String,Double> distance;
	


	
	
	
	
	
	
	
	
	
	
	
	// 各种get和set方法
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
//
//	public double[][] getTwoPlace() {
//		return twoPlace;
//	}
//
//	public void setTwoPlace(double[][] twoPlace) {
//		this.twoPlace = twoPlace;
//	}

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
