package presentation.InventoryUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.MainFrame;
import presentation.DeliverymanUI.SendApproveUI;
import client.Main;

public class KucunChooseUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private final String[] title = { "飞机分区", "火车分区", "汽车分区", "自动分区" };
	private JButton[] button;

	public KucunChooseUI() {
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		button = new JButton[4];
		for (int i = 0; i < 4; i++) {
			button[i] = new JButton(title[i]);
			button[i].setBounds(300, 70 + 70 * i, 200, 50);
			switch (i) {
			case 0:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new KucunguanliUI("飞机分区"));
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
							Main.frame.setView(new KucunguanliUI("火车分区"));
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
						try {
							Main.frame.setView(new KucunguanliUI("汽车分区"));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 3:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new KucunguanliUI("自动分区"));
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

}
