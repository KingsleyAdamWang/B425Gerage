package businessLogic_Stub;

import java.rmi.RemoteException;

import client.ClientInitException;
import vo.BussinessHallVo.ArrivalVO;
import businessLogicService.businessHallBLService.ArrivalBLService;

public class ArrivalBLStub implements ArrivalBLService {
	ArrivalVO vo;


	public void add(String id) {
		// TODO Auto-generated method stub

	}


	public void end() {
		// TODO Auto-generated method stub

	}

	public boolean submit(ArrivalVO vo) {
		// TODO Auto-generated method stub
		System.out.println("到达单提交成功");
		return true;
	}


	public String add(ArrivalVO arrivalVO) throws RemoteException,
			ClientInitException {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrivalVO search(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public String delete(ArrivalVO arrivalVO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
