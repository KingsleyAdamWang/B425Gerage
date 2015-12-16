package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.LogPO;
import presentation.MainFrame;
import vo.EntruckVO;
import vo.SendVO;
import businessLogicService.businessHallBLService.EntruckBLService;
import client.ClientInitException;
import client.RMIHelper;
import dataService.LogDataService;
import enumSet.TransportType;

public class EntruckController implements EntruckBLService {

	private EntruckBL entruckBL;
	private LogDataService logDS;
	
	public EntruckController() throws RemoteException, ClientInitException{
		entruckBL=new EntruckBL();
		RMIHelper.initLogDataService();
		logDS=RMIHelper.getLogDataService();
	}
	
	public String add(EntruckVO entruckVO) throws RemoteException {
		logDS.add(new LogPO(new Date(), MainFrame.getUser().getIdentityID(), "新增装车单"));
		return entruckBL.add(entruckVO);
	}


	public  EntruckVO search(String transferID) throws RemoteException {
		logDS.add(new LogPO(new Date(), MainFrame.getUser().getIdentityID(), "查询装车单"));
		return entruckBL.search(transferID);
	}
	
	public String delete(EntruckVO entruckVO) throws RemoteException{
		logDS.add(new LogPO(new Date(), MainFrame.getUser().getIdentityID(), "删除装车单"));
		return entruckBL.delete(entruckVO);
	}

	public String modify(EntruckVO entruckVO) throws RemoteException{
		logDS.add(new LogPO(new Date(), MainFrame.getUser().getIdentityID(), "修改装车单"));
		return entruckBL.modify(entruckVO);
	}
	
	public List<String> getInstitutionNames() throws RemoteException{
		return entruckBL.getInstitutionNames();
	}
	
	public double getDistance(String id,String name){
		return entruckBL.getDistance(id, name);
	}
	
	public double getFare(List<String> sendList){
		return entruckBL.getFare(sendList);
	}
	
	
//好像没用了，不管
	public String submit(EntruckVO eVO){
		// TODO Auto-generated method stub
		return null;
	}

}
