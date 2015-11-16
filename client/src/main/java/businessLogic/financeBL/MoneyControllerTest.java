package businessLogic.financeBL;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import vo.CashRegisterVO;
import vo.PaymentVO;
import businessLogic.businessHallBL.MockCashRegisterVO;

public class MoneyControllerTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testCashTotal() {
		MoneyController controller = new MoneyController();
		MockCashRegisterVO vo1 = new MockCashRegisterVO(3.95);
		MockCashRegisterVO vo2 = new MockCashRegisterVO(4.03);
		List<CashRegisterVO> list = new LinkedList<CashRegisterVO>();
		list.add(vo1);
		list.add(vo2);
		assertEquals(7.98, controller.getCashTotal(list));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testPayTotal() {
		MoneyController controller = new MoneyController();
		MockPaymentVO vo1 = new MockPaymentVO(3.95);
		MockPaymentVO vo2 = new MockPaymentVO(4.03);
		List<PaymentVO> list = new LinkedList<PaymentVO>();
		list.add(vo1);
		list.add(vo2);
		assertEquals(7.98, controller.getPayTotal(list));
	}
}
