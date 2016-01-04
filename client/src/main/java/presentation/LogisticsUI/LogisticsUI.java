package presentation.LogisticsUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import presentation.MainFrame;
import presentation.LoginUI.LoginFrame;
import vo.LogisticsVo.LogisticsVO;
import businessLogic.logisticsBL.LogisticsController;
import client.ClientInitException;
import client.Main;

public class LogisticsUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton inquireButton;
	private JButton returnButton;
	private JLabel label;
	private JTextField jTextField;
	private JTextArea area;
	private LogisticsController lc;

	public LogisticsUI() throws RemoteException, ClientInitException {
		this.lc = new LogisticsController();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.initComponents();
		this.validate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		label = new JLabel("快递单号");
		inquireButton = new JButton("查询");
		returnButton = new JButton("返回");
		jTextField = new JTextField(50);
		area = new JTextArea(6, 20);
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(jTextField);
		panel.add(inquireButton);
		panel.add(returnButton);
		this.add(panel);
		area.setEditable(false);
		this.add(area);

		inquireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setText("");
				if (jTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入快递单号", "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String s = jTextField.getText();
					LogisticsVO vo = lc.getLogisticsMessage(s);
					String temp = "快递单号:" + vo.id + "\t" + "快递名称:" + vo.name;
					area.setText(temp);
					List<String> msg = vo.getMessages();
					if (!vo.name.equals("未知")) {
						for (String tmp : msg) {
							String[] x = tmp.split("_");
							area.setText(area.getText() + "\n" + x[0] + "\t"
									+ x[1]);
						}
					} else {
						for (String tmp : msg) {
							area.setText(area.getText() + "\n" + tmp);
						}
					}
				}
			}
		});
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getUser() == null) {
					Main.frame.setVisible(false);
					LoginFrame loginFrame = new LoginFrame();
				} else {
					Main.frame.returnToTop();
				}
			}
		});
	}
}
