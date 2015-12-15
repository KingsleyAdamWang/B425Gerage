package businessLogic.deliveryBL;

import java.rmi.RemoteException;
import java.util.Date;

import po.LogPO;
import presentation.MainFrame;
import client.ClientInitException;
import client.RMIHelper;
import dataService.LogDataService;
import enumSet.Express;
import enumSet.PackType;
import vo.SendVO;
import businessLogicService.deliveryBLService.SendBLService;

public class SendController implements SendBLService {
	private SendBL sendBL;
	private LogDataService logDS;
	
	public SendController() throws RemoteException, ClientInitException{
		sendBL=new SendBL();
		RMIHelper.initLogDataService();
		logDS=RMIHelper.getLogDataService();
	}
	public String add(SendVO vo) throws RemoteException {
		logDS.add(new LogPO(new Date(),MainFrame.getUser().getIdentityID(),"新增寄件单"));
		return sendBL.add(vo);
	}
	
	public String delete(SendVO vo) throws RemoteException{
		logDS.add(new LogPO(new Date(),MainFrame.getUser().getIdentityID(),"删除寄件单"));
		return sendBL.delete(vo);
	}


	public double getFare(String departure, String destination, PackType packType,Express  transferType,double weight,double length,double width,double height) throws RemoteException, ClientInitException {
		return sendBL.getPrice(departure, destination, packType, transferType, weight,length,width,height);
	}
	
	public int getDays(String departure,String destination){
		
		return sendBL.getDays(departure,destination);
	}
	//只有以上的有用


	public SendVO search(SendVO sVO) {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
	public double getFare(String departure, String destination,
			String packType, String TransferType) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
