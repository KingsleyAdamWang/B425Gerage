package businessLogic.deliveryBL;

import java.rmi.RemoteException;

import vo.DeliverymanVo.ReceiveVO;
import businessLogicService.deliveryBLService.ReceiveBLService;

public class ReceiveController implements ReceiveBLService {
	private ReceiveBL receiveBL;
	
	public ReceiveController() throws RemoteException{
		receiveBL=new ReceiveBL();
	}

	public String add(ReceiveVO vo) throws RemoteException {

		return receiveBL.add(vo);
	}


	public String delete(ReceiveVO vo) throws RemoteException {

		return receiveBL.delete(vo);
	}
	
	

	public ReceiveVO search(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
