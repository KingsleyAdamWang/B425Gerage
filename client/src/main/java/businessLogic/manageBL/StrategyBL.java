package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.PriceConstPO;
import util.Distance;
import vo.PriceConstVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.PriceConstDataService;
import enumSet.Express;
import enumSet.PackType;

public class StrategyBL {
	private PriceConstDataService pcDS;
	private PriceConstPO pcPO;

	public StrategyBL() throws RemoteException {
		try {
			RMIHelper.initPriceConstDataService();
			pcDS = RMIHelper.getPriceConstDataService();
			pcPO = pcDS.getPriceConst();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public List<String> getCities() {
		List<String> cities = new ArrayList<String>();
		List<Distance> distances = pcPO.getDistances();
		int label1 = 0;// label表示状态，0表示未找到相同，1表示已找到相同
		int label2 = 0;
		for (Distance temp : distances) {
			label1 = 0;
			label2 = 0;
			String city1 = temp.getCity1();
			String city2 = temp.getCity2();
			for (String tempCity : cities) {
				if (tempCity.equals(city1)) {
					// 如果找到相同的城市，label设置为1，跳出
					label1 = 1;

				}
				if (tempCity.equals(city2)) {
					label2 = 1;

				}
				if (label1 == 1 && label2 == 1)
					break;
			}
			// 找到和未找到2中情况的判断
			if (label1 == 1 && label2 == 1) {
				continue;
			} else {
				if (label1 == 1) {
					label1 = 0;
				} else {
					cities.add(city1);
				}

				if (label2 == 1) {
					label2 = 0;
				} else {
					cities.add(city2);
				}
			}

		}

		return cities;
	}

	public PriceConstVO getVO() {
		if (pcPO != null) {
			PriceConstVO vo = new PriceConstVO(pcPO);
			return vo;
		}

		return null;
	}

	public String modify(PriceConstVO vo) throws RemoteException {
		PriceConstPO po = vo.transToPO();
		pcDS.update(po);
		return null;
	}

	public double getDistance(String city1, String city2) {
		List<Distance> distances = pcPO.getDistances();
		double result = 0;
		Distance newD = new Distance(city1, city2, 0);

		for (Distance temp : distances) {
			// if((temp.getCity1()==city1&&temp.getCity2()==city2)||(temp.getCity2()==city1&&temp.getCity1()==city2)){
			if (newD.equals(temp)) {
				result = temp.getDistance();
				return result;
			}
		}

		return result;
	}

	public double calSendPrice(String city1, String city2, PackType packType,
			Express expressType) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double calTransFare() {
		// TODO Auto-generated method stub
		return 0;
	}

}
