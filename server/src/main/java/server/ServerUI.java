package server;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ServerUI {
	private JFrame frame;
	private JLabel label;
	private JButton yesBtn;
	private JButton noBtn;
	private final int frameWidth = 300;
	private final int frameHeight = 150;

	public ServerUI() {
		frame = new JFrame("快递物流系统服务器");
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(3);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - frameWidth) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - frameHeight) / 2;
		frame.setLocation(w, h);

		label = new JLabel("是否启动服务器？");
		label.setSize(120, 20);
		label.setLocation(100, 30);
		frame.getContentPane().add(label);

		yesBtn = new JButton("确定");
		yesBtn.setBounds(70, 60, 60, 20);
		frame.getContentPane().add(yesBtn);
		noBtn = new JButton("退出");
		noBtn.setBounds(160, 60, 60, 20);
		frame.getContentPane().add(noBtn);

		yesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setLocation(100, 40);
				label.setText("正在启动服务器...");
				yesBtn.setVisible(false);
				noBtn.setVisible(false);
				startServer();
			}
		});
		noBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void setLabel() {
		label.setText("服务器已启动");
	}

	private void startServer() {
		try {
			// Logger.info("Try start server...");
			System.out.println("TRY START SERVER.....");
			RMIHelper.init();
			// Logger.info("Server is now running!");
			System.out.println("SERVER IS RUNNING...");
			setLabel();
		} catch (ServerInitException e) {
			System.out.println("SERVER START FAIL!!!");
			e.printStackTrace();
			Object[] options = { "重连", "退出" };
			int m = JOptionPane.showOptionDialog(null, "无法连接到服务器", "",
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null,
					options, options[0]);
			// JOptionPane.showMessageDialog(null, "无法连接到服务器", "",
			// JOptionPane.ERROR_MESSAGE);
			if (m == 0)
				startServer();
			else
				System.exit(0);
			// Logger.error("Server starts fail!");
			// Logger.error(e);
		}
	}
}
