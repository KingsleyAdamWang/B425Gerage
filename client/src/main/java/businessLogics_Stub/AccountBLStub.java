package businessLogics_Stub;

import java.util.ArrayList;
import java.util.List;

import businessLogicsService.AccountBLService;
import vo.AccountVO;

public class AccountBLStub implements AccountBLService {

	public void add(String name, double balance) {
		// TODO Auto-generated method stub

	}


	public void modify(AccountVO vo, String name) {
		// TODO Auto-generated method stub

	}


	public void delete(AccountVO vo) {
		// TODO Auto-generated method stub

	}


	public List<AccountVO> check(String key) {
		// TODO Auto-generated method stub
		List<AccountVO> list = new ArrayList<AccountVO>();
		return list;
	}

}
