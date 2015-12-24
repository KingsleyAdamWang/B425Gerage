package presentation.ManageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;

import client.Main;
import presentation.MainFrame;
import presentation.LogUI.LogUI;

public class ApproveChooseUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private final String[] title = { "审批寄件单", "审批装车单", "审批到达单", "审批中转单",
			"审批入库单", "审批出库单", "审批派件单", "审批收件单", "审批收款单", "审批付款单", "一键审批 " };
	private JButton[] button;

	public ApproveChooseUI() {
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		button = new JButton[11];
		for (int i = 0; i < 11; i++) {
			button[i] = new JButton(title[i]);
			button[i]
					.setBounds(150 + (i % 2) * 300, 70 + 70 * (i / 2), 200, 50);
			button[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			this.add(button[i]);
		}
	}

	public static void main(String[] args) {
		f = new MainFrame();
		ApproveChooseUI view = new ApproveChooseUI();
		f.setView(view);
	}
}
