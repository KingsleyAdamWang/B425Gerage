package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import vo.LogisticsVO;
import businessLogicService.logisticsBLService.InquireBLService;

public class LogisticsUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton inquireButton;
	private JLabel label;
	private JTextField jTextField;
	private JTextArea area;
	private InquireBLService bl;

	public LogisticsUI(InquireBLService bl) {
		this.bl = bl;
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
					try {
						List<LogisticsVO> list = bl.getLogisticsList(s);
						for (LogisticsVO vo : list) {
							String str = "";
							str += vo.getDate().toString();
							DateFormat df = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							str = df.format(vo.getDate());
							if (vo.getAddress() != null) {
								str += " 到达";
								str += vo.getAddress();
							} else if (vo.getNumber() != null) {
								str += " 派件中，派件员：";
								str += vo.getName();
								str += "，联系电话：";
								str += vo.getNumber();
							} else {
								str += " 已收件，收件员：";
								str += vo.getName();
							}
							area.setText(area.getText() + "\n" + str);
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
