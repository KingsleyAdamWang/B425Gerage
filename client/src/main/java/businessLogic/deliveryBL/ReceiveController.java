package businessLogic.deliveryBL;

import java.rmi.RemoteException;
import java.util.Date;

import presentation.MainFrame;
import vo.DeliverymanVo.ReceiveVO;
import vo.LogVo.LogVO;
import businessLogic.logBL.LogBL;
import businessLogicService.deliveryBLService.ReceiveBLService;

public class ReceiveController implements ReceiveBLService {
	private ReceiveBL receiveBL;
	private LogBL logBL;
	
	public ReceiveController() throws RemoteException{
		receiveBL=new ReceiveBL();
		logBL=new LogBL();
	}

	public String add(ReceiveVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增收件单"));
		return receiveBL.add(vo);
	}


	public String delete(ReceiveVO vo) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除收件单"));
		return receiveBL.delete(vo);
	}
	
	public String modify(ReceiveVO vo) throws RemoteException{
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"修改收件单"));
		return receiveBL.modify(vo);
	}
	
	

	public ReceiveVO search(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
