package businessLogicService.deliveryBLService;

import java.rmi.RemoteException;

import vo.DeliverymanVo.SendVO;

public interface SendBLService {
	public String add(SendVO sVO) throws RemoteException ;
	
	public double getFare(String departure, String destination, String packType, String TransferType);
	
	public String delete();
	
	public SendVO search(SendVO sVO);
}
