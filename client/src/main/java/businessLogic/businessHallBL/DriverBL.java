package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.List;

import po.DriverPO;
import util.CheckUtil;
import vo.DriverVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.DriverDataService;

public class DriverBL {
	DriverDataService driverDS;
	List<DriverPO> driverList;
	
	public DriverBL() throws RemoteException {
		try {
			RMIHelper.initDriverDataService();
			driverDS = RMIHelper.getDriverDataService();
			driverList = driverDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public DriverVO find(String id){
		try {
			return new DriverVO(driverDS.find(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String addDriver(DriverPO po){
//		DriverPO po=vo.transtoPO();
		
		for(DriverPO temp:driverList){
			if(temp.getId()==po.getId()){
				return "存在相同编号";
			}
		}
		
		if(!(CheckUtil.isNumber(po.getId())&&po.getId().length()==8)){
			return "人员编号格式有误";
		}
		
		
		driverList.add(po);
		try {
			driverDS.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	public String deleteDriver(DriverPO po){
		for(DriverPO temp:driverList){
			if(temp.getId().equals(po.getId())){
				driverList.remove(temp);
				try {
					driverDS.delete(po);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public String modify(DriverPO po){
		for(DriverPO temp:driverList){
			if(temp.getId().equals(po.getId())){
				try {
					driverDS.delete(po);
					driverList=driverDS.getList();
					addDriver(po);
					return null;
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "未找到对应司机";
	}
}
