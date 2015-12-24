package presentation.ManageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.MainFrame;
import presentation.BusinessHallUI.ArrivalApproveUI;
import presentation.BusinessHallUI.EntruckApproveUI;
import presentation.DeliverymanUI.ReceiveApproveUI;
import presentation.DeliverymanUI.SendApproveUI;
import presentation.FinanceUI.PaymentApproveUI;
import presentation.IntermediateUI.TransferApproveUI;
import presentation.InventoryUI.EntryApproveUI;
import presentation.InventoryUI.ShipmentApproveUI;
import businessLogic.manageBL.ApproveController;
import client.Main;

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
			switch (i) {
			case 0:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new SendApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 1:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new EntruckApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 2:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new ArrivalApproveUI());
					}
				});
				break;
			case 3:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new TransferApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 4:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new EntryApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 5:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new ShipmentApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 6:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new TransferApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 7:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new ReceiveApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 8:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new CashApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 9:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new PaymentApproveUI());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 10:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							ApproveController ac = new ApproveController();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			}
			this.add(button[i]);
		}
	}

	public static void main(String[] args) {
		f = new MainFrame();
		ApproveChooseUI view = new ApproveChooseUI();
		f.setView(view);
	}
}
