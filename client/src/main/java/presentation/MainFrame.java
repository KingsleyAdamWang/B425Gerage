package presentation;

import java.awt.Toolkit;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import presentation.AdminUI.AdminUI;
import presentation.BusinessHallUI.YYTUI;
import presentation.DeliverymanUI.KuaidiyuanUI;
import presentation.FinanceUI.FinanceHighUI;
import presentation.FinanceUI.FinanceLowUI;
import presentation.IntermediateUI.ZZZXUI;
import presentation.InventoryUI.CangkuUI;
import presentation.ManageUI.ManagerUI;
import vo.AdminVo.UserVO;
import businessLogic.logBL.LogController;
import client.Main;

/**
 * 一个界面跳转的管理frame的 uimanager 主要就是负责呈现各种人员对应的工作的Jpanel
 *
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final int frameWidth = 800;
	private final int frameHeight = 600;
	// 卧槽 我好喜欢 这个 user 爱死了 简直了 @！！
	private static UserVO user;
	public static ImageIcon background;
	public static JLabel label;

	// 构造函数 设置框架的风格为windows风格 //个人认为好丑呀
	public MainFrame() {
		try {
			new LogController();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 居中
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - frameWidth) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - frameHeight) / 2;
		this.setLocation(w, h);
		this.setSize(frameWidth, frameHeight);
		this.setResizable(false);
		// this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		background = new ImageIcon(getClass().getResource(
				"/picture/background.png"));
		label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		// this.getLayeredPane().add(label);
	}

	public void setView(JPanel panel) {
		this.setVisible(true);
		this.getContentPane().removeAll();

		// this.getLayeredPane().add(label);
		// JPanel jp = (JPanel) this.getContentPane();
		// jp.setOpaque(false);
		// panel.setOpaque(false);
		// jp.add(panel);

		this.getContentPane().add(panel);
		this.validate();
		this.repaint();
		this.getContentPane().repaint();
	}

	public void setView(JPanel panel, String s) {
		this.setTitle(s);
		this.setView(panel);
	}

	public void returnToTop() {
		String str = MainFrame.getUser().getWork().getPositionString();
		if (str.equals("管理员")) {
			Main.frame.setView(new AdminUI());
		} else if (str.equals("总经理")) {
			Main.frame.setView(new ManagerUI());
		} else if (str.equals("快递员")) {
			Main.frame.setView(new KuaidiyuanUI());
		} else if (str.equals("营业厅业务人员")) {
			Main.frame.setView(new YYTUI());
		} else if (str.equals("中转中心业务人员")) {
			Main.frame.setView(new ZZZXUI());
		} else if (str.equals("中转中心仓库管理员")) {
			Main.frame.setView(new CangkuUI());
		} else if (str.equals("财务人员（高）")) {
			Main.frame.setView(new FinanceHighUI());
		} else if (str.equals("财务人员（低）")) {
			Main.frame.setView(new FinanceLowUI());
		}
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public static UserVO getUser() {
		return user;
	}

	public static void setUser(UserVO user) {
		MainFrame.user = user;
	}

}
