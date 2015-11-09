package businessLogic_Stub;

import vo.DeliveryVO;
import businessLogicService.businessHallBLService.DeliveryBLService;

public class DeliveryBLStub implements DeliveryBLService {
	DeliveryVO vo;


	public void add(String id) {
		// TODO Auto-generated method stub

	}


	public void end() {
		// TODO Auto-generated method stub

	}


	public boolean submit(DeliveryVO vo) {
		// TODO Auto-generated method stub
		System.out.println("派件单提交成功");
		return true;
	}

}
