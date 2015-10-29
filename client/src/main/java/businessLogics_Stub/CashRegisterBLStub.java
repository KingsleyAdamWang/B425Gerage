package businessLogics_Stub;

import java.util.List;

import businessLogicsService.CashRegisterBLService;
import vo.CashRegisterVO;

public class CashRegisterBLStub implements CashRegisterBLService {
	CashRegisterVO vo;

	
	public void add(String id) {
		// TODO Auto-generated method stub

	}

	
	public void update() {
		// TODO Auto-generated method stub

	}

	
	public void end() {
		// TODO Auto-generated method stub

	}

	
	public boolean submit(CashRegisterVO vo) {
		// TODO Auto-generated method stub
		System.out.println("收款单提交成功");
		return true;
	}

	
	public double total(List<CashRegisterVO> lists) {
		
		double result=0.0;
				for(CashRegisterVO vo: lists){
					result+= vo.getFare();
				}
		return result;
	}
	

}
