package presentation.ManageUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import presentation.FinanceUI.RunFormUI;
import presentation.LogUI.LogUI;
import presentation.LoginUI.LoginFrame;
import vo.AdminVo.UserVO;
import client.Main;

public class ManagerUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton[] funcButton;
	private JTable table;
	private DefaultTableModel infoListModel;

	public ManagerUI() {
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
		// table.setRowHeight(0, 35);
		table.setRowHeight(30);
		table.setCellSelectionEnabled(false);
		// table.setBounds(50, 50, 700, 70);
		// for (int i = 0; i < 5; i++) {
		// table.setValueAt(info[i], 0, i);
		// }

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().add(table);
		scrollPane.setBounds(50, 50, 700, 58);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
		// this.add(table);

		funcButton = new JButton[7];
		final String[] title = { "人员机构管理", "查看经营情况", "审批单据", "薪水策略制定",
				"业务策略制定", "日志查询", "退出登录" };
		for (int i = 0; i < 7; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(150 + (i % 2) * 300, 180 + 90 * (i / 2),
					200, 50);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new InstManageUI(), "人员机构管理");
						} catch (RemoteException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new RunFormUI(), "查看经营情况");
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new ApproveChooseUI(), "审批单据");
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new SalaryUI(), "薪水策略制定");
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 4:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new StrategyUI(), "业务策略制定");
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 5:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new LogUI(), "日志查询");
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 6:
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
	// public static void main(String[] args) {
	// f = new MainFrame();
	// ManagerUI view = new ManagerUI();
	// f.setView(view);
	// }
}
