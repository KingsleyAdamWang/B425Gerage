package businessLogic_Stub;

import java.rmi.RemoteException;

import vo.BussinessHallVo.DeliveryVO;
import businessLogicService.businessHallBLService.DeliveryBLService;

public class DeliveryBLStub implements DeliveryBLService {
	DeliveryVO vo;


	public void add(String id) {
		// TODO Auto-generated method stub

	}


	public void end() {
		// TODO Auto-generated method stub

	}


	public String submit(DeliveryVO vo) {
		// TODO Auto-generated method stub
		System.out.println("派件单提交成功");
		return null;
	}


	public String add(DeliveryVO dVO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public DeliveryVO search(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public String delete(DeliveryVO dVO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
