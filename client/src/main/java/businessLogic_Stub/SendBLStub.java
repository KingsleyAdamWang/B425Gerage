package businessLogic_Stub;

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

}
