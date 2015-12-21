package businessLogic_Stub;

import vo.DeliverymanVo.ReceiveVO;
import businessLogicService.deliveryBLService.ReceiveBLService;

public class ReceiveBLStub implements ReceiveBLService {
	ReceiveVO vo;


	public void add(String id) {
		// TODO Auto-generated method stub

	}


	public void end() {
		// TODO Auto-generated method stub

	}


	public boolean submit(ReceiveVO vo) {
		// TODO Auto-generated method stub
		System.out.println("收件单提交成功");
		return true;
	}


	public String add(ReceiveVO rVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public String delete(ReceiveVO rVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public ReceiveVO search(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
