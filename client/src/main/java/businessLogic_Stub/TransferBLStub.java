package businessLogic_Stub;

import vo.TransferVO;
import businessLogicService.intermediateBLService.TransferBLService;

public class TransferBLStub implements TransferBLService {
	TransferVO vo;


	public void add(String id) {
		// TODO Auto-generated method stub

	}


	public void end() {
		// TODO Auto-generated method stub

	}


	public boolean submit(TransferVO vo) {
		// TODO Auto-generated method stub
		System.out.println("中转单提交成功");
		return true;
	}

}
