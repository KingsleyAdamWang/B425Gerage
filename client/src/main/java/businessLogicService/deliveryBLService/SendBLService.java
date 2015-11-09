package businessLogicService.deliveryBLService;

import vo.SendVO;

public interface SendBLService {
	public void add();
	
	public double getFare(String departure,String destination,double packFare);
	
	public boolean end();
	
	public boolean submit(SendVO send);
}
