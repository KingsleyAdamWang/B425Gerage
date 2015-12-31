package businessLogic.deliveryBL;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.deliveryPO.SendPO;
import po.inventoryPO.EntryPO;
import po.logisticsPO.LogisticsPO;
import po.managePO.PriceConstPO;
import util.CheckUtil;
import util.DateUtil;
import util.PackPrice;
import vo.DeliverymanVo.SendVO;
import vo.InventoryVo.EntryVO;
import businessLogic.logisticsBL.LogisticsBL;
import businessLogic.manageBL.StrategyBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.deliveryDataService.SendDataService;
import dataService.manageDataService.PriceConstDataService;
import enumSet.Express;
import enumSet.PackType;
import enumSet.ReceiptsState;

public class SendBL {
	SendDataService sendDS;
	List<SendPO> sendList;

	public SendBL() throws RemoteException {
		try {
			RMIHelper.initSendDataService();
			sendDS = RMIHelper.getSendDataService();
			sendList = sendDS.getSendList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public String add(SendVO vo) throws RemoteException {
		SendPO po = vo.transToPO();
		for (SendPO temp : sendList) {
			if (temp.getId().equals(po.getId()))
				return "存在相同编号的快递单";
		}

		if (!(CheckUtil.isNumber(po.getSender().getPostCode()) && po
				.getSender().getPostCode().length() == 6)) {
			return "邮编格式有误";
		}
		if (!(CheckUtil.isNumber(po.getSender().getTelephone()) && po
				.getSender().getTelephone().length() >= 7)) {
			return "寄件人电话格式有误";
		}
		if (!(CheckUtil.isNumber(po.getReceiver().getTelephone()) && po
				.getReceiver().getTelephone().length() >= 7)) {
			return "收件人电话格式有误";
		}

		// po.setWeight(getWeight(po.getWeight(),po.get));

		sendList.add(po);
		sendDS.add(po);
		LogisticsBL logisticsBL = new LogisticsBL();
		logisticsBL.add(new LogisticsPO(po.getId(), po.getName()));
		logisticsBL.update(po.getId(), "揽件成功");
		return null;
	}

	public String delete(SendVO vo) throws RemoteException {
		SendPO po = vo.transToPO();
		for (SendPO temp : sendList) {
			if (temp.getId().equals(vo.getId())) {
				sendList.remove(temp);
				sendDS.delete(temp);
				return null;
			}
		}

		return "未找到对应快递单";
	}

	public void modify(SendVO vo) throws RemoteException {
		for (SendPO temp : sendList) {
			if (temp.getId().equals(vo.id)) {
				sendList.set(sendList.indexOf(temp), vo.transToPO());
				sendDS.modify(vo.transToPO());
			}
		}
	}

	public double getWeight(double weight, double length, double width,
			double height) {
		double result = 0;
		double newWeight = 0;
		newWeight = length * width * height;
		if (weight > newWeight) {
			return weight;
		} else {
			return newWeight;
		}
	}

	public double getPrice(String city1, String city2, PackType packType,
			Express expressType, double weight, double length, double width,
			double height) throws RemoteException, ClientInitException {
		RMIHelper.initPriceConstDataService();
		PriceConstDataService pcDS = RMIHelper.getPriceConstDataService();
		PriceConstPO pcPO = pcDS.getPriceConst();

		// TODO 从StrategyBL 里得到距离，根据重量和速度计算时间，返回double类型数值
		double result;
		StrategyBL strategyBL = new StrategyBL();
		double distance = strategyBL.getDistance(city1, city2);
		double packFare = 0;// 包装费
		double expressCoeff = 0;// 快递类型对应的系数，根据类型取不同的值

		// 计算运送种类不同对应的系数
		if (expressType == Express.STANDARD) {
			expressCoeff = pcPO.getStandard();
		} else if (expressType == Express.FAST) {
			expressCoeff = pcPO.getFast();
		} else if (expressType == Express.ECONOMY) {
			expressCoeff = pcPO.getEconomy();
		}
		// 得到包装费
		List<PackPrice> packs = pcPO.getPackPrice();
		for (PackPrice temp : packs) {
			if (temp.getType() == packType) {
				packFare = temp.getFare();
				break;
			}
		}

		weight = this.getWeight(weight, length, width, height);

		result = (distance / 1000) * expressCoeff * weight + packFare;
		// 格式转化为2位小数
		DecimalFormat df = new DecimalFormat("#.00");

		return Double.parseDouble(df.format(result));
	}

	public int getDays(String departure, String destination) {
		List<SendPO> sendList = getSendListByCities(departure, destination);
		if (sendList.size() == 0) {
			return 0;
		}
		int result = 0;

		for (SendPO temp : sendList) {
			result = result + temp.getArriveDate();
		}

		result = result / sendList.size() + 1;
		return result;
	}

	private List<SendPO> getSendListByCities(String departure,
			String destination) {
		List<SendPO> result = new ArrayList<SendPO>();
		for (SendPO temp : this.sendList) {
			if (temp.getSender().getCity().equals(departure)
					&& temp.getReceiver().getCity().equals(destination)) {
				result.add(temp);
			}
		}
		return result;
	}

	public List<String> getCities() throws RemoteException {
		StrategyBL strategyBL = new StrategyBL();
		return strategyBL.getCities();
	}

	public SendVO getSend(String id) {
		for (SendPO temp : sendList) {
			if (temp.getId().equals(id)) {
				return new SendVO(temp);
			}
		}
		return null;
	}

	public List<SendVO> getSendByStaff(Date d, String id) {
		List<SendVO> sendList = new ArrayList<SendVO>();
		for (SendPO temp : this.sendList) {
			if (DateUtil.dateToString(temp.getD()).equals(
					DateUtil.dateToString(d))
					&& temp.getUserID().equals(id)) {
				sendList.add(new SendVO(temp));
			}
		}
		return sendList;
	}

	public void approve(SendPO po) throws RemoteException {
		sendDS.approval(po);
	}

	public void approveAll() throws RemoteException {
		sendDS.approvalAll();
	}

	public List<SendVO> getUnapproved() {
		List<SendVO> result = new ArrayList<SendVO>();
		for (SendPO temp : sendList) {
			if (temp.getState() == ReceiptsState.unapprove) {
				result.add(new SendVO(temp));
			}
		}
		return result;
	}

}
