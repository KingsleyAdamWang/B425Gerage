package server;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ServerUI {
	private JFrame frame;
	private JLabel label;
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

		label = new JLabel("服务器正在启动...");
		label.setSize(100, 20);
		label.setLocation(100, 40);
		frame.getContentPane().add(label);
	}

	public void setLabel() {
		label.setText("服务器已启动");
	}
}
