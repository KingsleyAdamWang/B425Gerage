package businessLogic.intermediateBL;

import vo.BussinessHallVo.EntruckVO;
import businessLogicService.businessHallBLService.EntruckBLService;

import java.rmi.RemoteException;
import java.util.Date;

import po.LogPO;
import presentation.MainFrame;
import client.ClientInitException;
import client.RMIHelper;
import dataService.logDataService.LogDataService;

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
	
//好像没用了，不管
	public String submit(EntruckVO eVO){
		// TODO Auto-generated method stub
		return null;
	}

}
