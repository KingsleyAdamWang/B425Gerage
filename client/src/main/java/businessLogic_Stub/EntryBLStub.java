package businessLogic_Stub;

import vo.EntryVO;
import businessLogicService.inventoryBLService.EntryBLService;

public class EntryBLStub implements EntryBLService {
	EntryVO vo;


	public boolean submit(EntryVO vo) {
		// TODO Auto-generated method stub
		System.out.println("入库单提交成功");
		return true;
	}

}
