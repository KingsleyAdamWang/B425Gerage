package businessLogicService.deliveryBLService;

import vo.SendVO;

public interface SendBLService {
	public String add(SendVO sVO) ;
	
	public double getFare(String departure, String destination, String packType, String TransferType);
	
	public String delete();
	
	public SendVO search(SendVO sVO);
}
