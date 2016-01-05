package presentation.DeliverymanUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.DeliverymanVo.ReceiveVO;
import businessLogic.deliveryBL.ReceiveController;
import client.Main;
import enumSet.ReceiptsState;

public class ReceiveUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private ReceiveController rc;
	private final String[] labelName = { "快递单号", "收件人姓名", "收件人电话", "收件日期" };
	private JLabel[] label;
	private JTextField[] field;
	private JButton submitBtn;
	private JButton returnBtn;

	public ReceiveUI() throws RemoteException {
		rc = new ReceiveController();
		this.initComponents();
		this.validate();
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[4];
		field = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 100 + 50 * i, 100, 20);
			this.add(label[i]);
			field[i] = new JTextField();
			field[i].setBounds(305, 100 + 50 * i, 250, 30);
			this.add(field[i]);
		}
		field[3].setText(DateUtil.dateToString());

		submitBtn = new JButton("提交");
		submitBtn.setBounds(200, 450, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 450, 100, 30);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					String result = rc.add(getReceiveVO());
					if (result != null) {
						JOptionPane.showMessageDialog(null, result, "",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "提交成功", "",
								JOptionPane.INFORMATION_MESSAGE);
						Main.frame.setView(new ReceiveUI(), "填写收件单");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "输入数字格式有误", "",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.returnToTop();
			}
		});
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 4; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	private ReceiveVO getReceiveVO() {
		return new ReceiveVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), field[0].getText(),
				field[1].getText(), field[2].getText(), field[3].getText());
	}
}
