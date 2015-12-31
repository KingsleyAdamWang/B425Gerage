package businessLogic.loginBL;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import enumSet.Position;
import po.adminPO.UserPO;

public class TestLoginBL {
	LoginBL loginBL;
	
	public void setUp() throws RemoteException{
		loginBL=new LoginBL();
	}
	
	@Test
	public void testLogin() throws RemoteException {
		UserPO po = new UserPO("wangdong", "12345","00000001", "000001", Position.JOB_1);
//		bl.list.add(po);
		assertEquals(true, loginBL.login("wangdong", "12345"));
	}

}
