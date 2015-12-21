package businessLogic.loginBL;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import po.UserPO;
import vo.BussinessHallVo.CashRegisterVO;
import businessLogic.businessHallBL.CashRegisterController;
import businessLogic.businessHallBL.MockCashRegisterVO;

public class LoginBLTest {

	@Test
	public void testLogin() throws RemoteException {
		LoginBL bl = new LoginBL();
		UserPO po = new MockUserPO("wangdong", "12345");
//		bl.list.add(po);
		assertEquals(true, bl.login("wangdong", "12345"));
	}

}
