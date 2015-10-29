package businessLogics_Stub;

import businessLogicsService.EntryBLService;
import vo.EntryVO;

public class EntryBLStub implements EntryBLService {
	EntryVO vo;


	public boolean submit(EntryVO vo) {
		// TODO Auto-generated method stub
		System.out.println("入库单提交成功");
		return true;
	}

}
