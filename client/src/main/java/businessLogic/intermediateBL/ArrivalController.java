package businessLogic.intermediateBL;

import java.rmi.RemoteException;
import java.util.Date;

import presentation.MainFrame;
import vo.BussinessHallVo.ArrivalVO;
import vo.LogVo.LogVO;
import businessLogic.logBL.LogBL;
import businessLogicService.businessHallBLService.ArrivalBLService;
import client.ClientInitException;

public class ArrivalController implements ArrivalBLService {
	private ArrivalBL arrivalBL;
	private LogBL logBL;

	public ArrivalController() throws RemoteException {
		arrivalBL = new ArrivalBL();
		logBL = new LogBL();
	}

	public String add(ArrivalVO arrivalVO) throws RemoteException,
			ClientInitException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"新增到达单"));
		return arrivalBL.add(arrivalVO);
	}

	public ArrivalVO search(String transferID) throws RemoteException {// 根据单号查找到达单
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"查找到达单"));
		return arrivalBL.search(transferID);
	}

	public String delete(ArrivalVO arrivalVO) throws RemoteException {
		logBL.add(new LogVO(new Date(), MainFrame.getUser().getIdentityID(),
				"删除到达单"));
		return arrivalBL.delete(arrivalVO);
	}

	public String getInstitutionName() throws RemoteException {
		return arrivalBL.getInstitutionName();
	}

	@Override
	public String modify(ArrivalVO arrivalVO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
