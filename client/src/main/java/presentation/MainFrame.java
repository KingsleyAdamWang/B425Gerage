package presentation;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

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
    private static UserVO user ;
	private static LogController logController;
	//构造函数  设置框架的风格为windows风格  //个人认为好丑呀 
	public MainFrame() {
		logController = new LogController();
		
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//居中
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
//		清空所有mainFrame上面的组件 这样真的好咩 万一要返回还要再新建一个面板加进去？
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.getContentPane().validate();
		this.repaint();
	}
	
	public void setView(JPanel panel,String s) {
		this.setTitle(s);
		this.setView(panel);
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
