package businessLogic_Stub;

import vo.EntruckVO;
import businessLogicService.businessHallBLService.EntruckBLService;

public class EntruckBLStub implements EntruckBLService {
	EntruckVO vo;

	
	public void add(String id) {
		// TODO Auto-generated method stub

	}

	
	public void end() {
		// TODO Auto-generated method stub

	}

	
	public boolean submit(EntruckVO vo) {
		// TODO Auto-generated method stub
		System.out.println("装车单提交成功");
		return true;
	}

}
