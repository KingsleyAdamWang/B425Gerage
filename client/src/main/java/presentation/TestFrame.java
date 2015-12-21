package presentation;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import po.AccountPO;
import presentation.LoginUI.LoginFrame;
import vo.AccountVO;
import client.ClientInitException;
import client.RMIHelper;
import dataService.AccountDataService;

public class TestFrame extends JFrame {
	public static void main(String[] args) throws ClientInitException,
			RemoteException {

		new LoginFrame(null);
		
//		// 测试代码 只是来测试一下RMI进程实现没有
//		MainFrame mainFrame = new MainFrame();
//		mainFrame.setView(new SendUI());
//
//		// 初始化并获取accountDataService对象
//		RMIHelper.initAccountDataService();
//		AccountDataService accountDataServie = RMIHelper
//				.getAccountDataService();
//
//		List<AccountPO> pos = accountDataServie.getAccounts();
//
//		ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
//		vos.add(pos.get(0).transferToVO());
//		System.out.println(vos.size() + "   " + vos.get(0).getAccountID());
//
//		System.out.println(pos.size());
	}

}
