package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.businessPO.TruckPO;
import vo.BussinessHallVo.TruckVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.businessHallDataService.TruckDataService;

public class TruckBL {
	private TruckDataService truckDS;
	private List<TruckPO> truckList;

	public TruckBL() throws RemoteException {
		try {
			RMIHelper.initTruckDataService();
			truckDS = RMIHelper.getTruckDataService();
			truckList = truckDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public List<TruckVO> getAllTruckVOList(){
		List<TruckVO> result=new ArrayList<TruckVO>();
		for(TruckPO temp:truckList){
			result.add(new TruckVO(temp));
		}
		return result;
	}

	public TruckPO find(String id) {
		try {
			return truckDS.find(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String add(TruckPO po) {
		for (TruckPO temp : truckList) {
			if (temp.getTruckID().equals(po.getTruckID())
					|| temp.getTruckNumber().equals(po.getTruckNumber())) {
				return "存在相同编号或相同车牌号的车辆";
			}
		}

		truckList.add(po);
		try {
			truckDS.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String delete(TruckPO po) {
		try {
			for (TruckPO temp : truckList) {
				if (temp.equals(po)) {
					truckDS.delete(po);
					truckList = truckDS.getList();
					return null;
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "未找到对应车辆";

	}

	public String modify(TruckPO po) {
		try {
			for (TruckPO temp : truckList) {
				if (temp.equals(po)) {
					truckDS.modify(po);
					truckList = truckDS.getList();
					return null;
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "未找到对应车辆";
	}
}
