package client;

import java.awt.Toolkit;
import java.rmi.RemoteException;

import presentation.LoginFrame;
import presentation.MainFrame;
import businessLogic.loginBL.LoginController;
import businessLogicService.loginBLService.LoginBLService;

public class Main {
	public static MainFrame frame;

	public static void main(String[] args) throws RemoteException,
			ClientInitException {
		frame = new MainFrame();
		frame.setVisible(false);

		LoginBLService bl = new LoginController();
		LoginFrame loginFrame = new LoginFrame(bl);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - loginFrame
				.getFrameWidth()) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - loginFrame
				.getFrameHeight()) / 2;
		loginFrame.getLoginFrame().setLocation(w, h);
	}
}
