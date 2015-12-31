package businessLogic.businessHallBL;

import java.rmi.RemoteException;
import java.util.Date;

import presentation.MainFrame;
import vo.BussinessHallVo.DeliveryVO;
import vo.DeliverymanVo.SendVO;
import vo.LogVo.LogVO;
import businessLogic.logBL.LogBL;
import businessLogicService.businessHallBLService.DeliveryBLService;

public class DeliveryController implements DeliveryBLService {
	private DeliveryBL deliveryBL;
	private LogBL logBL;

	public DeliveryController() throws RemoteException {
		deliveryBL = new DeliveryBL();
		logBL = new LogBL();
	}

	public String add(DeliveryVO deliveryVO) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增派件单"));
		return deliveryBL.add(deliveryVO);
	}

	public DeliveryVO search(String id) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"查找派件单"));
		return deliveryBL.search(id);
	}

	public String delete(DeliveryVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除派件单"));
		return deliveryBL.delete(vo);
	}

	public SendVO getSendMessage(String ID) throws RemoteException {
		return deliveryBL.getSendMessage(ID);
	}

	public String submit(DeliveryVO dVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
