package presentation.IntermediateUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentation.MainFrame;
import presentation.BusinessHallUI.ArrivalUI;
import presentation.BusinessHallUI.EntruckUI;
import presentation.LoginUI.LoginFrame;
import vo.AdminVo.UserVO;
import client.ClientInitException;
import client.Main;

public class ZZZXUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton[] funcButton;
	private JTable table;
	private DefaultTableModel infoListModel;

	public ZZZXUI() {
		this.initComponents();
		this.validate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);
		String[] info = { "姓名", "员工编号", "职位", "机构编号" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 4; i++) {
			vColumns.add(info[i]);
		}
		Vector<String[]> vData = new Vector<String[]>();

		infoListModel = new DefaultTableModel(vData, vColumns);
		UserVO user = MainFrame.getUser();
		infoListModel.addRow(new String[] { user.getName(),
				user.getIdentityID(), user.getWork().getPositionString(),
				user.getInstitutionID() });
		table = new JTable(infoListModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setRowHeight(30);
		table.setCellSelectionEnabled(false);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().add(table);
		scrollPane.setBounds(50, 50, 700, 58);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);

		funcButton = new JButton[3];
		final String[] title = { "填写到达单", "填写装车单", "填写中转单", "退出登录" };
		for (int i = 0; i < 3; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(300, 180 + 90 * i, 200, 50);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new ArrivalUI(), "填写到达单");
						} catch (RemoteException e1) {
							e1.printStackTrace();
						} catch (ClientInitException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new EntruckUI(), "填写装车单");
						} catch (RemoteException e1) {
							e1.printStackTrace();
						} catch (ClientInitException e1) {
							e1.printStackTrace();

						}
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new TransferUI(), "填写中转单");
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int n = JOptionPane.showConfirmDialog(null, "确定要退出登录?",
								"", JOptionPane.YES_NO_OPTION);
						if (n == 0) {
							Main.frame.setVisible(false);
							LoginFrame frame = new LoginFrame();
						}
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}
}
