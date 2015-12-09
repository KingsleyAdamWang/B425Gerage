package businessLogic_Stub;

import java.rmi.RemoteException;

import vo.SendVO;
import businessLogicService.deliveryBLService.SendBLService;

public class SendBLStub implements SendBLService {
	SendVO send;


	public void add() {
		// TODO Auto-generated method stub

	}


	public double getFare(String departure, String destination, double packFare) {
		// TODO Auto-generated method stub
		return 20.5;
	}


	public boolean end() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean submit(SendVO send) {
		// TODO Auto-generated method stub
		System.out.println("寄件单提交成功");
		return true;
	}


	public String add(SendVO sVO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public double getFare(String departure, String destination,
			String packType, String TransferType) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}


	public SendVO search(SendVO sVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
