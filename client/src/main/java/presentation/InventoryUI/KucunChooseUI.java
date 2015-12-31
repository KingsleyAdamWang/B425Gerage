package presentation.InventoryUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.MainFrame;
import client.Main;

public class KucunChooseUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private final String[] title = { "飞机分区", "火车分区", "汽车分区", "自动分区" };
	private JButton[] button;

	public KucunChooseUI() {
		this.initComponents();
		this.validate();
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		button = new JButton[4];
		for (int i = 0; i < 4; i++) {
			button[i] = new JButton(title[i]);
			button[i].setBounds(300, 100 + 100 * i, 200, 50);
			switch (i) {
			case 0:
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new KucunguanliUI("飞机分区"));
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
							Main.frame.setView(new KucunguanliUI("火车分区"));
						} catch (RemoteException e1) {
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
