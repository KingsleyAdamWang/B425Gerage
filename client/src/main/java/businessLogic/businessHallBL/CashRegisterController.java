package businessLogic.businessHallBL;

import java.util.List;
import java.rmi.RemoteException;
import vo.CashRegisterVO;
import businessLogicService.businessHallBLService.CashRegisterBLService;

public class CashRegisterController implements CashRegisterBLService {


	public String add(CashRegisterVO crVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public String search(String id) {//根据单号查找收款单
		// TODO Auto-generated method stub
		return null;
	}


	public String delete(CashRegisterVO crVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public String submit(CashRegisterVO crVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public double total(List<CashRegisterVO> lists) {//根据收款单列表得到收款总额
		// TODO Auto-generated method stub
		return 0;
	}

}
