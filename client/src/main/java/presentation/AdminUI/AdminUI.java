package presentation.AdminUI;

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
import vo.AdminVo.UserVO;
import client.ClientInitException;
import client.Main;

public class AdminUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton[] funcButton;
	private JTable table;
	private DefaultTableModel infoListModel;

	public AdminUI() {
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

		funcButton = new JButton[5];
		final String[] title = { "账户密码管理" };
		for (int i = 0; i < 1; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(300, 170 + 70 * i, 200, 50);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new AdminSearchUI(), "账户密码管理");
						} catch (ClientInitException e1) {
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
}