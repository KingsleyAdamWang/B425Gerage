package presentation;

import java.awt.Toolkit;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import client.Main;
import vo.UserVO;
import businessLogic.logBL.LogController;

/**
 * //一个界面跳转的管理frame的 uimanager 主要就是负责呈现各种人员对应的工作的Jpanel
 *
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final int frameWidth = 800;
	private final int frameHeight = 600;
	// 卧槽 我好喜欢 这个 user 爱死了 简直了 @！！
	private static UserVO user;
	private static LogController logController;

	// 构造函数 设置框架的风格为windows风格 //个人认为好丑呀
	public MainFrame() {
		try {
			logController = new LogController();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
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
	}

	public void setView(JPanel panel) {
		this.setVisible(true);
		// 清空所有mainFrame上面的组件 这样真的好咩 万一要返回还要再新建一个面板加进去？
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.getContentPane().validate();
		this.repaint();
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
			Main.frame.setView(new YYTUI());
		} else if (str.equals("中转中心仓库管理员")) {
			Main.frame.setView(new CangkuUI());
		} else if (str.equals("财务人员（高）")) {
			Main.frame.setView(new FinanceUI());
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
