package presentation.LogisticsUI;

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

import client.ClientInitException;
import vo.LogisticsVO;
import businessLogic.logisticsBL.LogisticsController;

public class LogisticsUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton inquireButton;
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

	private void initComponents() {
		label = new JLabel("快递单号");
		inquireButton = new JButton("查询");
		jTextField = new JTextField(50);
		area = new JTextArea(6, 20);
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(jTextField);
		panel.add(inquireButton);
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
					List<String> msg = vo.getMessages();
					for (String tmp : msg) {
						// String str = "";
						// str += vo.getDate().toString();
						// DateFormat df = new SimpleDateFormat(
						// "yyyy-MM-dd HH:mm:ss");
						// str = df.format(vo.getDate());
						// if (vo.getAddress() != null) {
						// str += " 到达";
						// str += vo.getAddress();
						// } else if (vo.getNumber() != null) {
						// str += " 派件中，派件员：";
						// str += vo.getName();
						// str += "，联系电话：";
						// str += vo.getNumber();
						// } else {
						// str += " 已收件，收件员：";
						// str += vo.getName();
						// }
						// str += vo.getMessages();
						area.setText(area.getText() + "\n" + tmp);
					}
				}
			}
		});
	}
}
