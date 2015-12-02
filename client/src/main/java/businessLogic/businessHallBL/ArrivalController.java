package businessLogic.businessHallBL;

import vo.ArrivalVO;
import businessLogicService.businessHallBLService.ArrivalBLService;

import java.rmi.RemoteException;
import java.util.List;

public class ArrivalController implements ArrivalBLService {
	private ArrivalBL arrivalBL;
	
	public ArrivalController() throws RemoteException{
		arrivalBL=new ArrivalBL();
	}

	public String add(ArrivalVO arrivalVO) throws RemoteException {
		
		return arrivalBL.add(arrivalVO);
	}


	public ArrivalVO search(String transferID) {//根据单号查找到达单
		
		return arrivalBL.search(transferID);
	}


	public String delete(ArrivalVO arrivalVO) throws RemoteException {
		
		return arrivalBL.delete(arrivalVO);
	}
	
	public String modify(ArrivalVO arrivalVO) throws RemoteException{
		
		return arrivalBL.modify(arrivalVO); 
	}
	//根据装车单信息返回对应所有快递单号的列表
	public List<String> getIDList(String entruckID) throws RemoteException{
		return arrivalBL.getIDList(entruckID);
	}

}
