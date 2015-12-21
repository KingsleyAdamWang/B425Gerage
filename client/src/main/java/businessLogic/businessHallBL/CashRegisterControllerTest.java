package businessLogic.businessHallBL;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import vo.BussinessHallVo.CashRegisterVO;

public class CashRegisterControllerTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testTotal() throws RemoteException {
		CashRegisterController controller = new CashRegisterController();
		MockCashRegisterVO vo1 = new MockCashRegisterVO(3.95);
		MockCashRegisterVO vo2 = new MockCashRegisterVO(4.03);
		List<CashRegisterVO> list = new LinkedList<CashRegisterVO>();
		list.add(vo1);
		list.add(vo2);
		assertEquals(7.98, controller.total(list));
	}
	
}
