package presentation.ManageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentation.MainFrame;
import presentation.LogUI.LogUI;
import vo.UserVO;
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

		funcButton = new JButton[6];
		final String[] title = { "人员机构管理", "查看统计分析", "审批单据", "薪水策略制定",
				"业务策略制定", "日志查询" };
		for (int i = 0; i < 6; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(150 + (i / 3) * 300, 200 + 100 * (i % 3),
					200, 50);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new InstManageUI(), "人员机构管理");
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new ApprovalUI(), "审批单据");
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new SalaryUI(), "薪水策略制定");
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
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
							// TODO Auto-generated catch block
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
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}

//	public static void main(String[] args) {
//		f = new MainFrame();
//		ManagerUI view = new ManagerUI();
//		f.setView(view);
//	}
}
