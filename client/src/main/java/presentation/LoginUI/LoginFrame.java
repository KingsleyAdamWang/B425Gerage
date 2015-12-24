package presentation.LoginUI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStreamReader;
import java.io.Reader;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;

import presentation.MainFrame;
import presentation.AdminUI.AdminUI;
import presentation.BusinessHallUI.YYTUI;
import presentation.DeliverymanUI.KuaidiyuanUI;
import presentation.FinanceUI.FinanceHighUI;
import presentation.FinanceUI.FinanceLowUI;
import presentation.InventoryUI.CangkuUI;
import presentation.LogisticsUI.LogisticsUI;
import presentation.ManageUI.ManagerUI;
import businessLogic.loginBL.LoginController;
import client.ClientInitException;
import client.Main;
import client.RMIHelper;

public class LoginFrame {

	private LoginController lc;
	private JFrame frame;
	private JButton loginButton;
	private JButton cancelButton;
	private JButton guestButton;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel setting;
	private JTextField jTextField;
	private JPasswordField jPasswordField;
	private ImageIcon iconB;
	private ImageIcon iconG;
	private int flag = 0;
	private JButton button;
	private JLabel[] label;
	private JTextField[] field;
	private final int frameWidth = 300;
	private final int frameHeight = 200;

	// private LoginBLService bl;

	public LoginFrame() {
		try {
			// 设置为windows风格
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 初始化各种部件
		componentsInstantiation();
		initComponents();

		frame.setVisible(true);

	}

	private void componentsInstantiation() {

		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		loginButton = new JButton("登录");
		cancelButton = new JButton("取消");
		guestButton = new JButton("访客入口");
		usernameLabel = new JLabel("用户名:");
		passwordLabel = new JLabel("密  码:");

		jTextField = new JTextField(20);
		jPasswordField = new JPasswordField(20);
////
//		Reader   reader   =new   InputStreamReader( 
//		        getClass().getResourceAsStream("/picture/Environment.ini")); 
		iconB=new   ImageIcon(getClass().getResource("/picture/setting_black.png")); 

		//iconB = new ImageIcon("src/main/java/picture/setting_black.png");
		iconG = new ImageIcon(getClass().getResource("/picture/setting_gray.png"));
		// icon = new
		// ImageIcon("C:\\Users\\Kradness\\Documents\\B425Gerage\\client\\src\\main\\java\\picture\\setting.png");
		setting = new JLabel(iconG);
		// Image setting = new
		// ImageIcon("src/main/java/picture/setting.png").getImage();
	}

	private void initComponents() {
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - this.frameWidth) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - this.frameHeight) / 2;
		this.frame.setLocation(w, h);

		// 初始化各种登陆界面的组件
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("EDMS登录界面");

		usernameLabel.setBounds(50, 20, 50, 20);
		frame.getContentPane().add(usernameLabel);
		jTextField.setBounds(100, 20, 140, 20);
		frame.getContentPane().add(jTextField);

		passwordLabel.setBounds(50, 65, 50, 20);
		frame.getContentPane().add(passwordLabel);
		jPasswordField.setBounds(100, 65, 140, 20);
		frame.getContentPane().add(jPasswordField);

		loginButton.setBounds(30, 110, 60, 25);
		frame.getContentPane().add(loginButton);
		cancelButton.setBounds(200, 110, 60, 25);
		frame.getContentPane().add(cancelButton);
		guestButton.setBounds(105, 110, 80, 25);
		frame.getContentPane().add(guestButton);

		setting.setBounds(270, 150, 20, 20);
		setting.setIcon(iconG);
		frame.getContentPane().add(setting);

		JSeparator js = new JSeparator();
		js.setBounds(0, 180, 300, 1);
		frame.getContentPane().add(js);

		label = new JLabel[3];
		String[] name = { "服务器配置", "ip地址:", "端  口:" };
		for (int i = 0; i < 3; i++) {
			label[i] = new JLabel(name[i]);
			if (i == 0) {
				label[i].setBounds(10, 180, 100, 20);
			} else {
				label[i].setBounds(50, 210 + 40 * (i - 1), 50, 20);
			}
			frame.getContentPane().add(label[i]);
		}
		field = new JTextField[2];
		for (int i = 0; i < 2; i++) {
			field[i] = new JTextField();
			field[i].setBounds(100, 210 + 40 * i, 140, 20);
			frame.getContentPane().add(field[i]);
		}
		button = new JButton("应用");
		button.setBounds(110, 280, 80, 25);
		frame.getContentPane().add(button);

		frame.setSize(frameWidth, frameHeight);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		guestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guestLogin();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClientInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		setting.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (flag == 0) {
					frame.setSize(300, 350);
					flag = 1;
				} else {
					frame.setSize(300, 200);
					flag = 0;
				}
			}

			public void mouseEntered(MouseEvent e) {
				setting.setIcon(iconB);
			}

			public void mouseExited(MouseEvent e) {
				setting.setIcon(iconG);
			}
		});

		field[0].setText(RMIHelper.getIP());
		field[1].setText(RMIHelper.getPORT());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RMIHelper.applyConfig(field[0].getText(), field[1].getText());
				JOptionPane.showMessageDialog(null, "应用成功", "",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	/**
	 * 登录的一些状况反馈
	 */
	private void login() {
		// 没输入账户名
		if (jTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入用户名", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 没输入密码
		if (new String(jPasswordField.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入密码", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Main.frame = new MainFrame();
		Main.frame.setVisible(false);
		try {
			this.lc = new LoginController();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 获取用户输入的账户名和密码
		String username = jTextField.getText();
		String password = new String(jPasswordField.getPassword());
		// 我就想看下 显示一下密码
		System.out.println("账号为：" + username);
		System.out.println("密码是：" + password);
		// 调用bl层查看是否有该账户的信息
		// 如果账户和密码输入正确则登录
		boolean result = false;
		try {
			result = lc.login(username, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result) {
			Main.frame.setVisible(true);
			frame.setVisible(false);
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
				Main.frame.setView(new FinanceHighUI());
			} else if (str.equals("财务人员（低）")) {
				Main.frame.setView(new FinanceLowUI());
			}
		} else {
			JOptionPane.showMessageDialog(null, "用户名或密码不正确", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	private void guestLogin() throws RemoteException, ClientInitException {
		Main.frame = new MainFrame();
		Main.frame.setVisible(false);
		try {
			this.lc = new LoginController();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// MainFrame frame = new MainFrame();
		Main.frame.setView(new LogisticsUI(), "物流信息查询");
		frame.setVisible(false);
	}

	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
	}

}
