package businessLogics_Stub;

import businessLogicsService.ReceiveBLService;
import vo.ReceiveVO;

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

}
