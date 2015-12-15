package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.DriverPO;
import po.EntruckPO;
import po.InstitutionPO;
import vo.EntruckVO;
import vo.InstitutionVO;
import businessLogic.manageBL.InstitutionBL;
import businessLogic.manageBL.StrategyBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.EntruckDataService;
import enumSet.InsType;

public class EntruckBL {
	private EntruckDataService entruckDS;
	private List<EntruckPO> entruckList;
	
	public EntruckBL() throws RemoteException {
		try {
			RMIHelper.initEntruckDataService();
			entruckDS = RMIHelper.getEntruckDataService();
			entruckList = entruckDS.getEntruckList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}
	
	public EntruckVO search(String EntruckID) throws RemoteException{
		for(EntruckPO temp: entruckList){
			if(temp.getQyID()==EntruckID){
				return new EntruckVO(temp);
			}
		}
		return null;
		
		//发现DataService里有find方法。如果没有，用上面注释的内容应该也行。
//		return new EntruckVO(entruckDS.find(EntruckID));
	}
	
	public String add(EntruckVO vo) throws RemoteException{
		EntruckPO po=vo.transToPO();
		
		for(EntruckPO temp: entruckList){
			if(temp.equals(po)){
				return "存在单号相同的装车单";
			}
		}
		
		entruckList.add(po);
		entruckDS.add(po);
		return null;
	}
	
	public String delete(EntruckVO vo) throws RemoteException{
		EntruckPO po=vo.transToPO();
		
		for(EntruckPO temp: entruckList){
			if(temp.equals(po)){
				entruckList.remove(temp);
				entruckDS.delete(temp);
				return null;
			}
		}
		return "未找到对应装车单";
	}
	
	public String modify(EntruckVO vo) throws RemoteException{
		EntruckPO po=vo.transToPO();
		
		for(EntruckPO temp: entruckList){
			if(temp.equals(po)){
				entruckDS.modify(po);
				//不知道这样更新entruckList行不行，试一下
				entruckList=entruckDS.getEntruckList();
				return null;
			}
		}
		
		return "未找到对应装车单";
	}
	
	public List<String> getInstitutionNames() throws RemoteException{
		InstitutionBL institutionBL=new InstitutionBL();
		List<InstitutionVO> insVOList=institutionBL.showByCity();
		List<String> result=new ArrayList<String>();
		for(InstitutionVO temp: insVOList){
			result.add(temp.getName());
		}
		return result;
	}
	
	private InstitutionPO getInsByName(String name) throws RemoteException{
		InstitutionBL institutionBL=new InstitutionBL();
		return institutionBL.searchByName(name);
	}
	private InstitutionVO getInsByID(String id) throws RemoteException{
		InstitutionBL institutionBL=new InstitutionBL();
		return institutionBL.searchInstitution(id);
	}
	
	public List<String> getDriverNames(String id,String name) throws RemoteException{
		List<String> driverNames=new ArrayList<String>();
		DriverBL driverBL=new DriverBL();
		List<DriverPO> drivers;
		try {
			if(getInsByID(id).getType()==InsType.businessHall){
				driverNames=driverBL.getDriverNamesByIns(id);
			}else{
				driverNames=driverBL.getDriverNamesByIns(getInsByName(name).getInstitutionID());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return driverNames;
	}
	
	public double getDistance(String id,String name){
		double result=0;
		try {
			StrategyBL strategyBL=new StrategyBL();
			result=strategyBL.getDistance(getInsByID(id).getCity(), getInsByName(name).getCity());
			if(result==0){
				return result;
			}else{
				return 30;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
			
		return 0;
	}
	
	public double getFare(String departureID,String destinationName){
		double fare=0;
		double distance=getDistance(departureID,destinationName);
		//TODO 根据距离算运费
		return fare;
	}
	
	//提供给别的BL使用的
	public List<String> getGoodsID(String entruckID) throws RemoteException{
		EntruckPO po=entruckDS.find(entruckID);
		
		return po.getIDlist();
	}
	
	
}
