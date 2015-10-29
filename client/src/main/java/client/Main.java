package client;

import java.awt.Toolkit;

import presentation.LoginFrame;
import presentation.MainFrame;
import businessLogicsImpl.LoginBL;
import businessLogicsService.LoginBLService;


public class Main {
	public static MainFrame frame;
	
	public static void main(String[] args){
		frame = new MainFrame();
		frame.setVisible(false);
		
		LoginBLService bl = new LoginBL();
		LoginFrame loginFrame = new LoginFrame(bl);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - loginFrame.getFrameWidth()) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - loginFrame.getFrameHeight()) / 2;
		loginFrame.getLoginFrame().setLocation(w, h);
	}
}
