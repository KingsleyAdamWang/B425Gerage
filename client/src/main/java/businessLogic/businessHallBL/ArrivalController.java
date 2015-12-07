package businessLogic.businessHallBL;

import vo.ArrivalVO;
import businessLogicService.businessHallBLService.ArrivalBLService;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import po.LogPO;
import presentation.MainFrame;
import client.ClientInitException;
import client.RMIHelper;
import dataService.LogDataService;

public class ArrivalController implements ArrivalBLService {
	private ArrivalBL arrivalBL;
	private LogDataService logDS;
	
	public ArrivalController() throws RemoteException, ClientInitException{
		arrivalBL=new ArrivalBL();
		RMIHelper.initLogDataService();
		logDS=RMIHelper.getLogDataService();
	}

	public String add(ArrivalVO arrivalVO) throws RemoteException {
		logDS.add(new LogPO(new Date(), MainFrame.getUser().getIdentityID(), "新增到达单"));
		return arrivalBL.add(arrivalVO);
	}


	public ArrivalVO search(String transferID) throws RemoteException {//根据单号查找到达单
		logDS.add(new LogPO(new Date(),MainFrame.getUser().getIdentityID(),"查询到达单"));
		return arrivalBL.search(transferID);
	}


	public String delete(ArrivalVO arrivalVO) throws RemoteException {
		logDS.add(new LogPO(new Date(), MainFrame.getUser().getIdentityID(), "删除到达单"));
		return arrivalBL.delete(arrivalVO);
	}
	
	public String modify(ArrivalVO arrivalVO) throws RemoteException{
		logDS.add(new LogPO(new Date(), MainFrame.getUser().getIdentityID(), "修改到达单"));
		return arrivalBL.modify(arrivalVO); 
	}
	//根据装车单信息返回对应所有快递单号的列表
	public List<String> getIDList(String entruckID) throws RemoteException{
		return arrivalBL.getIDList(entruckID);
	}

}
