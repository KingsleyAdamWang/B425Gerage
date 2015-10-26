package edms.presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edms.businesslogic.InquireBL;
import edms.businesslogicservice.InquireBLService;
import edms.businesslogicservice.LoginBLService;
import edms.main.Main;

public class LoginFrame {
	private JFrame loginFrame;
	private JButton loginButton;
	private JButton cancelButton;
	private JButton guestButton;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField jTextField;
	private JPasswordField jPasswordField;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private final int frameWidth = 300;
	private final int frameHeight = 200;
	private LoginBLService bl;

	public LoginFrame(LoginBLService bl) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		componentsInstantiation();
		initComponents();
		loginFrame.setVisible(true);
		this.bl = bl;
	}

	private void componentsInstantiation() {
		loginFrame = new JFrame();
		loginButton = new JButton("登录");
		cancelButton = new JButton("取消");
		guestButton = new JButton("访客入口");
		usernameLabel = new JLabel("用户名");
		passwordLabel = new JLabel("密  码");
		jTextField = new JTextField(20);
		jPasswordField = new JPasswordField(20);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
	}

	private void initComponents() {
		loginFrame
				.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.setTitle("EDMS登录界面");
		loginFrame.setLayout(new GridLayout(3, 1));

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
				guestLogin();
			}
		});

		panel1.add(usernameLabel);
		panel1.add(jTextField);
		panel2.add(passwordLabel);
		panel2.add(jPasswordField);
		panel3.add(loginButton);
		panel3.add(cancelButton);
		panel3.add(guestButton);

		loginFrame.add(panel1);
		loginFrame.add(panel2);
		loginFrame.add(panel3);
		loginFrame.setSize(frameWidth, frameHeight);
	}

	private void login() {
		if (jTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入用户名", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (new String(jPasswordField.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入密码", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		String username = jTextField.getText();
		String password = new String(jPasswordField.getPassword());
		boolean result = bl.login(username, password);
		if (!result) {
			// MainFrame frame = new MainFrame();
			Main.frame.setView(new SendView(),"填写寄件单");
			loginFrame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "用户名或密码不正确", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	private void guestLogin() {
		// MainFrame frame = new MainFrame();
		Main.frame.setView(new InquireView(new InquireBL()),"物流信息查询");
		loginFrame.setVisible(false);
	}

	public JFrame getLoginFrame() {
		return loginFrame;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

}
