package presentation.BusinessHallUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.CustomerVO;
import vo.BussinessHallVo.DeliveryVO;
import vo.DeliverymanVo.SendVO;
import businessLogic.businessHallBL.DeliveryController;
import businessLogic.manageBL.ApproveController;
import client.Main;
import enumSet.ReceiptsState;

public class DeliveryModifyUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private DeliveryController dc;
	private final String[] labelName = { "快递单号", "派送员", "到达日期", "订单信息" };
	private JLabel[] label;
	private JTextField[] field;
	private JTextArea area;
	private JButton submitBtn;
	private JButton returnBtn;
	private DeliveryVO vo;

	public DeliveryModifyUI(DeliveryVO vo) throws RemoteException {
		this.vo = vo;
		dc = new DeliveryController();
		this.initComponents();
		this.validate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[4];
		field = new JTextField[3];
		for (int i = 0; i < 4; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			// label[i].setBounds(20 + 400 * (i % 2), 40 + 40 * (i / 2), 100,
			// 20);
			label[i].setBounds(220, 70 + 50 * i, 100, 20);
			this.add(label[i]);
			if (i < 3) {
				field[i] = new JTextField();
				field[i].setBounds(305, 70 + 50 * i, 250, 30);
				this.add(field[i]);
			} else {
				area = new JTextArea();
				area.setBounds(305, 70 + 50 * i, 250, 280);
				this.add(area);
			}
		}
		field[2].setText(DateUtil.dateToString());

		field[0].addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				try {
					setArea(field[0].getText());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});

		submitBtn = new JButton("保存修改");
		returnBtn = new JButton("返回");
		submitBtn.setBounds(250, 520, 80, 30);
		returnBtn.setBounds(450, 520, 80, 30);
		this.add(submitBtn);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					new ApproveController().modifyDelivery(getDeliveryVO());
					JOptionPane.showMessageDialog(null, "修改成功", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.frame.setView(new DeliveryApproveUI());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		field[0].setText(vo.id);
		field[1].setText(vo.name);
		field[2].setText(DateUtil.dateToString(vo.d));
		try {
			setArea(vo.id);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 3; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	private DeliveryVO getDeliveryVO() {
		return new DeliveryVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), DateUtil.stringToDate(field[2]
				.getText()), field[0].getText(), field[1].getText());
	}

	private void setArea(String id) throws RemoteException {
		SendVO vo = dc.getSendMessage(id);
		if (vo != null) {
			CustomerVO r = vo.receiver;
			String s = "";
			s += "货物名称：\t";
			s += vo.name;
			s += "\n收件人姓名：\t";
			s += r.name;
			s += "\n收件人地址：\t";
			s += r.address;
			s += "\n收件人单位：\t";
			s += r.company;
			s += "\n收件人电话：\t";
			s += r.telephone;
			area.setText(s);
		}
	}
}
