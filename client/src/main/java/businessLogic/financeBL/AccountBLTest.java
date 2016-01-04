package businessLogic.financeBL;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import po.financePO.AccountPO;
import vo.FinanceVo.AccountVO;
import businessLogicService.financeBLService.AccountBLService;

public class AccountBLTest{
	AccountPO accountPO;
	AccountBL accountBL;
	
	public AccountBLTest() throws RemoteException{
		accountBL=new AccountBL();
	}
	@Test
	public void testAddAccount() throws RemoteException {
		AccountBL bl = new AccountBL();
		AccountPO po = new AccountPO("王栋", "141250133", 0);
		bl.accounts.add(po);
		assertEquals("账户名已存在！添加失败！", bl.addAccount("王栋", "12345"));
	}

	public void testModifyAccount() throws RemoteException {
		AccountBL bl = new AccountBL();
		AccountPO po1 = new AccountPO("王栋", "141250133", 0);
		AccountPO po2 = new AccountPO("王傻栋", "141250133", 0);
		bl.accounts.add(po1);
		bl.accounts.add(po2);
		AccountVO vo = new AccountVO(po2);
		assertEquals("账户名已存在！添加失败！", bl.modifyAccount(vo));
	}
	
	public void testDeleteAccount(AccountVO testVO) throws RemoteException{
		AccountPO po1 = new AccountPO("王栋", "141250133", 0);
		AccountPO po2 = new AccountPO("王傻栋", "141250133", 0);
		accountBL.accounts.add(po1);
		accountBL.accounts.add(po2);
		AccountVO vo = new AccountVO(po2);
		assertEquals(false, accountBL.deleteAccount( po2));
	}

}
