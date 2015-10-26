package edms.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import edms.businesslogicservice.InquireBLService;
import edms.vo.LogisticsVO;

public class InquireView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton inquireButton;
	private JLabel label;
	private JTextField jTextField;
	private JTextArea area;
	private InquireBLService bl;

	public InquireView(InquireBLService bl) {
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
							str = df.format(str);
							str += " 到达";
							str += vo.getAddress();
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
