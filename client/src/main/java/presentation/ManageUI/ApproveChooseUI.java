package presentation.ManageUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presentation.MainFrame;
import presentation.BusinessHallUI.ArrivalApproveUI;
import presentation.BusinessHallUI.CashApproveUI;
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
	private static final long serialVersionUID = 1L;

	private final String[] title = { "审批寄件单", "审批装车单", "审批到达单", "审批中转单",
			"审批入库单", "审批出库单", "审批派件单", "审批收件单", "审批收款单", "审批付款单", "一键审批 " };
	private JButton[] button;

	public ApproveChooseUI() {
		this.initComponents();
		this.validate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
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
							e1.printStackTrace();
						}
					}
				});
				break;
			case 8:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new CashApproveUI());
					}
				});
				break;
			case 9:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new PaymentApproveUI());
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 10:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int n = JOptionPane.showConfirmDialog(null,
								"确定通过所有单据的审批?", "", JOptionPane.YES_NO_OPTION);
						if (n == 0) {
							try {
								ApproveController ac = new ApproveController();
								ac.setAllApprovedArrival();
								ac.setAllApprovedDelivery();
								ac.setAllApprovedEntruck();
								ac.setAllApprovedEntry();
								ac.setAllApprovedIncome();
								ac.setAllApprovedPayment();
								ac.setAllApprovedReceive();
								ac.setAllApprovedSend();
								ac.setAllApprovedShipment();
								ac.setAllApprovedTransfer();
							} catch (RemoteException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
				break;
			}
			this.add(button[i]);
		}
	}
}
