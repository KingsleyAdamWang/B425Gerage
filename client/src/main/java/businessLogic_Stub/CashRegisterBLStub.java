package businessLogic_Stub;

import java.rmi.RemoteException;
import java.util.List;

import vo.BussinessHallVo.CashRegisterVO;
import businessLogicService.businessHallBLService.CashRegisterBLService;

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

	
	public String submit1(CashRegisterVO vo) {
		// TODO Auto-generated method stub
		System.out.println("收款单提交成功");
		return null;
	}

	
	public double total(List<CashRegisterVO> lists) {
		
		double result=0.0;
				for(CashRegisterVO vo: lists){
					result+= vo.getFare();
				}
		return result;
	}


	public String add(CashRegisterVO crVO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public String search(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public String delete(CashRegisterVO crVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public String submit(CashRegisterVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
