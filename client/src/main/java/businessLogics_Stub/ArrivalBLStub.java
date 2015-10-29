package businessLogics_Stub;

import vo.ArrivalVO;
import businessLogicsService.ArrivalBLService;

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

}
