package client;

import java.awt.Toolkit;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import presentation.MainFrame;
import presentation.LoginUI.LoginFrame;
import businessLogic.loginBL.LoginController;
import businessLogicService.loginBLService.LoginBLService;

public class Main {
	public static MainFrame frame;

	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
	}
}
