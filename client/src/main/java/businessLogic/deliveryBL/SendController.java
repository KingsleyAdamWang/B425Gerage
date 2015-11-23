package businessLogic.deliveryBL;

import java.rmi.RemoteException;

import vo.SendVO;
import businessLogicService.deliveryBLService.SendBLService;

public class SendController implements SendBLService {
	SendBL sendBL;
	
	public SendController() throws RemoteException{
		sendBL=new SendBL();
	}
	public String add(SendVO vo) throws RemoteException {
		return sendBL.add(vo);
	}
	
	public String delete(SendVO vo) throws RemoteException{
		return sendBL.delete(vo);
	}
//只有以上的有用

	public double getFare(String departure, String destination, String packType, String TransferType) {
		return 0;
	}


	public SendVO search(SendVO sVO) {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
